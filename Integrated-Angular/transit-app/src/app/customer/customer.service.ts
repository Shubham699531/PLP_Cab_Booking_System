import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TripDetails } from '../model/tripDetails';
import { Payment } from '../model/payment';
import { Report } from '../model/report';
import { Booking } from '../model/booking';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(public http:HttpClient) { }

  savePayment(booking : Booking){
    return this.http.post<Payment>("http://localhost:8880/driver/addPaym", booking);
   }
 
   saveReport(booking : Booking){
    return this.http.post<Report>("http://localhost:8880/driver/addFeedback", booking);
   }

   getCustomer(booking : Booking){
    return this.http.post<Customer>("http://localhost:8880/driver/findCustomer", booking);
   }
}
