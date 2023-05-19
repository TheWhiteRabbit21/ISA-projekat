package ISA.projekat.DTOs;

public class PageDTO {
    public int pageSize;
    public int pageIndex;

    public PageDTO() {
    }

    public PageDTO(int pageSize, int pageIndex) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }
}
