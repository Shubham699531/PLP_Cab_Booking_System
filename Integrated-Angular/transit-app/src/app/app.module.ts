import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TransitDriverComponent } from './transit-driver/transit-driver.component';
import { TransitUserComponent } from './transit-user/transit-user.component';
import { NavRoutingModule } from './nav/nav-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AddPaymentComponent } from './add-payment/add-payment.component';
import { AddReportComponent } from './add-report/add-report.component';
import { TripEndedComponent } from './trip-ended/trip-ended.component';

@NgModule({
  declarations: [
    AppComponent,
    TransitDriverComponent,
    TransitUserComponent,
    AddPaymentComponent,
    AddReportComponent,
    TripEndedComponent
  ],
  imports: [
    BrowserModule, FormsModule, NavRoutingModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
