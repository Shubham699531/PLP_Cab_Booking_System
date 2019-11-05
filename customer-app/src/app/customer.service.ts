import { Injectable } from '@angular/core';
import { Booking } from './model/booking.model';
import { HttpClient } from '@angular/common/http';
import { User } from './model/user.model';
import { Customer } from './model/customer.model';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  booking : Booking;
  cust : Customer;
  constructor(private httpClient : HttpClient) { }

  verifyLogin(user : User){
    //console.log(user.email);
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/login",user);
    //console.log(this.cust);
    //return this.cust;
  }

  getBookingDetails(user : User){
    return this.httpClient.post<Booking>("http://localhost:8180/cbs/bookingService",user);
  // return this.httpClient.post<Customer>("http://localhost:8079/login",user);
  }


}
