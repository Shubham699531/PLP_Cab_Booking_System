import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './addDriver/signup.component';
import { ListComponent } from './listDriver/list.component';
import { AppRoutingModule } from './app/app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReportComponent } from './customerIssues/report.component';
import { FetchComponent } from './fetchDriver/fetch.component';
import { SolveComponent } from './solveIssues/solve.component';
import { HomeComponent } from './home/home.component';
import { BookingdetailsComponent } from './bookingdetails/bookingdetails.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ListComponent,
    ReportComponent,
    FetchComponent,
    SolveComponent,
    HomeComponent,
    BookingdetailsComponent,
  
    
  ],
  imports: [
    BrowserModule, FormsModule, BsDatepickerModule.forRoot(), AppRoutingModule, HttpClientModule,NgxPaginationModule, BrowserAnimationsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
