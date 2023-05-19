package ISA.projekat;

import ISA.projekat.Model.Complaint;
import ISA.projekat.Service.ComplaintService;
import ISA.projekat.Service.RegisteredUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjekatApplicationTests {


	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private RegisteredUserService userService;

	@Before
	public void setUp() throws Exception {
		complaintService.save(new Complaint("Odlicnoooo", null));
		complaintService.save(new Complaint("Superr", null));
		complaintService.save(new Complaint("Tooooo", null));
	}

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void testOptimisticLockingScenario() throws Throwable {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<?> future1 = executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Startovan Thread 1");
				Complaint productToUpdate = complaintService.findById(1);// ocitan objekat sa id 1
				productToUpdate.setResponse("Vazi");// izmenjen ucitan objekat
				try { Thread.sleep(3000); } catch (InterruptedException e) {}// thread uspavan na 3 sekunde da bi drugi thread mogao da izvrsi istu operaciju
				complaintService.save(productToUpdate);// bacice ObjectOptimisticLockingFailureException
			}
		});
		executor.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("Startovan Thread 2");
				Complaint productToUpdate = complaintService.findById(1);// ocitan isti objekat sa id 1 kao i iz prvog threada
				productToUpdate.setResponse("Hvala");// izmenjen ucitan objekat
				/*
				 * prvi ce izvrsiti izmenu i izvrsi upit:
				 * Hibernate:
				 *     update
				 *         product
				 *     set
				 *         name=?,
				 *         origin=?,
				 *         price=?,
				 *         version=?
				 *     where
				 *         id=?
				 *         and version=?
				 *
				 * Moze se primetiti da automatski dodaje na upit i proveru o verziji
				 */
				complaintService.save(productToUpdate);
			}
		});
		try {
			future1.get(); // podize ExecutionException za bilo koji izuzetak iz prvog child threada
		} catch (ExecutionException e) {
			System.out.println("Exception from thread " + e.getCause().getClass()); // u pitanju je bas ObjectOptimisticLockingFailureException
			throw e.getCause();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();

	}

}
