import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './addDriver/signup.component';
import { ListComponent } from './listDriver/list.component';
import { AppRoutingModule } from './app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReportComponent } from './customerIssues/report.component';
import { SolveComponent } from './solveIssues/solve.component';
import { HomeComponent } from './home/home.component';
import { BookingdetailsComponent } from './bookingdetails/bookingdetails.component'; 
 import { NgxPaginationModule } from 'ngx-pagination';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from '../app.component';
//import { AppComponent } from '../app.component';

@NgModule({

  declarations: [
    LoginComponent,
    SignupComponent,
    ListComponent,
    ReportComponent,
    SolveComponent,
    HomeComponent,
    BookingdetailsComponent,
  
  ],

  imports: [
    BrowserModule, FormsModule,  AppRoutingModule, HttpClientModule,
     NgxPaginationModule, 
    BrowserAnimationsModule 
  ],
  providers: [],
  bootstrap: [],
  exports:[
    LoginComponent,
    SignupComponent,
    ListComponent,
    ReportComponent,
    SolveComponent,
    HomeComponent,
    BookingdetailsComponent
  ]
})  

export class AdminModule { }
