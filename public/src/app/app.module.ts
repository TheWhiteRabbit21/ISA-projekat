import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MaterialModule } from "./material/material.module";
import { HospitalModule } from "./modules/hospital/hospital.module";
import { PagesModule } from "./modules/pages/pages.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { AuthInterceptor } from "./modules/pages/login/log-auth-interceptor.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    PagesModule,
    HospitalModule,
    FormsModule
  ],
  providers: [    {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi : true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
