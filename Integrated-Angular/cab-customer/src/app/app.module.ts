import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DatePipe } from '@angular/common';
import { AddPaymentComponent } from './add-payment/add-payment.component';
import { AddReportComponent } from './add-report/add-report.component';
import { TransitDriverComponent } from './transit-driver/transit-driver.component';
import { TransitUserComponent } from './transit-user/transit-user.component';
import { TripEndedComponent } from './trip-ended/trip-ended.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { AdminModule } from './admin/admin.module';
import { CabRoutingModule } from './cab/cab-routing.module';
import { CustSignupComponent } from './cust-signup/cust-signup.component';
import { DriverSignupComponent } from './driver-signup/driver-signup.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    CustomerHomeComponent,
    CustSignupComponent,
    DriverSignupComponent,
    HeaderComponent,
    FooterComponent,
    AddPaymentComponent,
    AddReportComponent,
    TransitDriverComponent,
    TransitUserComponent,
    TripEndedComponent
    
  ],
  imports: [
    AdminModule,
    BrowserModule,
    FormsModule, 
    HttpClientModule,
    NaviRoutingModule,
    CabRoutingModule,
    BsDatepickerModule.forRoot(),


  ],
  providers: [ DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
