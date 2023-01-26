import { HttpClient } from "@angular/common/http"
import { Injectable } from "@angular/core"
import { Observable, tap, switchMap, EMPTY, take, map } from "rxjs"
import { environment } from "src/environments/environment"
import { UserDataService } from "src/app/modules/pages/login/log-user-data.service"

export interface LoginDTO {
  username: string;
  password: string;
}

@Injectable({
  providedIn: "root"
})
export class AuthService {
  constructor(private m_UserDataService: UserDataService, private m_Http: HttpClient) {
    this.m_UserDataService.m_Token$.pipe(
      take(1),
      switchMap(token => {
        if (token) return this.getUserData();
        return EMPTY;
      })
    ).subscribe();
  }

  login(loginDTO: LoginDTO): Observable<any> {
    return this.m_Http.post(`${environment.hospitalApiUrl}/auth/login`, loginDTO).pipe(
      map((res: any) => {
        this.m_UserDataService.setToken = res['accessToken'];
        console.log(res['accessToken']);
        console.log(res);
      }),
      switchMap(_ => this.getUserData())
    );
  }

  logout(): void {
    this.m_UserDataService.setToken = null;
    this.m_UserDataService.setUserData = null;
  }

  getUserData(): Observable<any> {
    return this.m_Http.get(`${environment.hospitalApiUrl}/api/users/data`).pipe(
      tap((res: any) => {
        console.log(res);
        this.m_UserDataService.setUserData = res;
      })
    )
  }

}
