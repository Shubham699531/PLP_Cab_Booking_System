import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HistoryComponent } from './history/history.component';
import { BookingComponent } from './booking/booking.component';
import { NaviRoutingModule } from './navi/navi-routing.module';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { CustomerHomeComponent } from './customer-home/customer-home.component';
import { FindTripComponent } from './find-trip/find-trip.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HistoryComponent,
    BookingComponent,
    CustomerHomeComponent,
    FindTripComponent
  ],
  imports: [
    BrowserModule, NaviRoutingModule, FormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
