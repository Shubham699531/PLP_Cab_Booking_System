import { Injectable } from '@angular/core';
import { Booking } from './model/booking.model';
import { HttpClient } from '@angular/common/http';
import { User } from './model/user.model';
import { Customer } from './model/customer.model';
import { CustomerRequest } from './model/customer_requirement.model';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  locations:string[] =[];
  price:number;

  booking : Booking;
  customer : Customer;

  constructor(private httpClient : HttpClient) { 
    this.customer = new Customer();
    console.log("Service constructor");
  }

  getPastTrips(){
    return this.httpClient.post<Booking[]>("http://localhost:8180/cbs/pastTrips",this.customer);
  }

  getLocations(){
    return this.httpClient.get<string[]>("http://localhost:8180/cbs/allLocations");
  }

  getEstimatePrice(details :CustomerRequest){
    return this.httpClient.post<number>("http://localhost:8180/cbs/estimateFare",details);
  }

  saveBookingRequest(details : CustomerRequest){
    return this.httpClient.post<CustomerRequest>("http://localhost:8180/cbs/saveCustomerRequest", details);
  }

  verifyLogin(user : User){
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/loginCustomer",user);
  }

  registerCustomer(customer : Customer){
    return this.httpClient.post<Customer>("http://localhost:8180/cbs/signupCustomer",customer);
  }

  setCustomer(cust : Customer){
    this.customer = cust;
    console.log(this.customer.id + "#" + this.customer.email);
  }
  getCustomer(){
    return this.customer;
  }

  findACab(requirement : CustomerRequest){
    return this.httpClient.post<Booking>("http://localhost:8180/cbs/findACab",requirement);
  // return this.httpClient.post<Customer>("http://localhost:8079/login",user);
  }

}
