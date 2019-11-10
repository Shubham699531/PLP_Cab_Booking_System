import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomerRequest } from '../model/customer_requirement.model';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Report } from '../model/report.model';
import { Booking } from '../model/booking.model';
import { Customer } from '../model/customer.model';
import { User } from '../model/user.model';
import { Payment } from '../model/payment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  locations: string[] = [];
  price: number;
  booking: Booking;
  customer: Customer;

  constructor(private httpClient: HttpClient) {
    this.customer = new Customer();
    console.log("Service constructor");
  }

  getPastTrips() {
    return this.httpClient.post<Booking[]>("http://localhost:8180/cbs/pastTrips", this.customer);
  }

  getLocations() {
    return this.httpClient.get<string[]>("http://localhost:8180/cbs/allLocations");
  }

  getEstimatePrice(details: CustomerRequest) {
    return this.httpClient.post<number>("http://localhost:8180/cbs/estimateFare", details);
  }

  saveBookingRequest(details: CustomerRequest) {
    return this.httpClient.post<CustomerRequest>("http://localhost:8180/cbs/saveCustomerRequest", details);
  }

  verifyLogin(user: User) {
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/loginCustomer", user);
  }

  registerCustomer(customer: Customer) {
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/signupCustomer", customer).pipe(retry(1), catchError(this.errorHandler));
  }

  setCustomer(cust: Customer) {
    this.customer = cust;
  }
  getCustomerId() {
    return this.customer;
  }

  findACab(requirement: CustomerRequest) {
    return this.httpClient.post<Booking>("http://localhost:8180/cbs/findACab", requirement);
  }
  savePayment(booking : Booking){
    return this.httpClient.post<Payment>("http://localhost:8880/driver/addPaym", booking);
   }
 
   saveReport(booking : Booking){
    return this.httpClient.post<Report>("http://localhost:8880/driver/addFeedback", booking);
   }

   getCustomer(booking : Booking){
    return this.httpClient.post<Customer>("http://localhost:8880/driver/findCustomer", booking);
   }
  errorHandler(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) { //client side error
      errorMessage = `Error: ${error.error.message}`;
    }
    else { //server side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.error}`;
    }
    window.alert(errorMessage);
    return throwError(error.error)
  }



}
