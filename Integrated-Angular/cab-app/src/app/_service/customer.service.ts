import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';
import { CustomerRequest } from '../model/customer_requirement.model';
import { Booking } from '../model/booking.model';
import { Driver } from '../model/driver.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  
  constructor(private http: HttpClient) { 

  }

  verifyLogin(user : User){
    //http://localhost:8180/cbs/loginCustomer
    return this.http.post<Customer>("http://localhost:8180/cbs/loginCustomer", user);
  }

  signUp(customer: Customer){
    //http://localhost:8180/cbs/signupCustomer
    return this.http.post<Customer>("http://localhost:8180/cbs/signupCustomer", customer);
  }
  getEstimatePrice(tripdetails:CustomerRequest) {
    return this.http.post<number>("http://localhost:8180/cbs/estimateFare", tripdetails);
  }
  saveBooking(tripdetails:CustomerRequest) {
    return this.http.post<CustomerRequest>("http://localhost:8180/cbs/saveCustomerRequest",tripdetails);
  }

  getLocations(){
    return this.http.get<string[]>("http://localhost:8180/cbs/allLocations");
  }

  findACab(tripdetails: CustomerRequest){
    return this.http.post<Booking>("http://localhost:8180/cbs/findACab", tripdetails);
  }

  findDriverById(id: number){
    return this.http.get<Driver>("http://localhost:8180/cbs/driverById/" + id);
  }

  checkBookingStatus(customerId: number){
    return this.http.get<Booking>("http://localhost:8180/cbs/checkBookingStatus?customerId=" + customerId);
  }


}
