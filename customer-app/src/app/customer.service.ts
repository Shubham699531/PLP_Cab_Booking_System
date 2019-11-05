import { Injectable } from '@angular/core';
import { Booking } from './model/booking.model';
import { HttpClient } from '@angular/common/http';
import { User } from './model/user.model';
import { Customer } from './model/customer.model';
import { CustomerRequirement } from './model/customer_requirement.model';
import { AppComponent } from './app.component';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  isHiddenLogin : boolean;
  isHiddenDashBoard: boolean;
  booking : Booking;
  customer : Customer;
  constructor(private httpClient : HttpClient) { 
    this.isHiddenLogin = false;
    this.isHiddenDashBoard = true;
  }


  verifyLogin(user : User){
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/loginCustomer",user);
  }

  registerCustomer(customer : Customer){
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/signupCustomer",customer);
  }

  setCustomer(cust : Customer){
    this.customer = cust;
  }
  getCustomer(){
    return this.customer;
  }

  getBookingDetails(requirement : CustomerRequirement){
    return this.httpClient.post<Booking>("http://localhost:8180/cbs/bookingService",requirement);
  // return this.httpClient.post<Customer>("http://localhost:8079/login",user);
  }


}
