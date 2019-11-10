import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { DriverComponent } from './driver/driver.component';
import { CustomerComponent } from './customer/customer.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app/app-routing.module';
import { CustSignupComponent } from './cust-signup/cust-signup.component';
import { DriverSignupComponent } from './driver-signup/driver-signup.component';
import { DatePipe } from '@angular/common';
import { BookCabComponent } from './customer/book-cab/book-cab.component';
import { ShowPastTripsComponent } from './customer/show-past-trips/show-past-trips.component';
import { ShowTripStatusComponent } from './customer/show-trip-status/show-trip-status.component';
import { AddPaymentComponent } from './customer/add-payment/add-payment.component';
import { AddReportComponent } from './customer/add-report/add-report.component';

import { TransitComponent } from './driver/transit/transit.component';
import { HttpClientModule } from '@angular/common/http';
import { PastTripsComponent } from './driver/part-trips/part-trips.component';
import { AboutDriverComponent } from './driver/about-driver/about-driver.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    DriverComponent,
    CustomerComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    CustSignupComponent,
    DriverSignupComponent,
    ShowPastTripsComponent,
    ShowTripStatusComponent,
    BookCabComponent,
    AddPaymentComponent,
    AddReportComponent,
    PastTripsComponent,
    TransitComponent,
    AboutDriverComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
    
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
