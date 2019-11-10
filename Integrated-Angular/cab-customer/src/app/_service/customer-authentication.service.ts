import { Injectable } from '@angular/core';
import { CustomerService } from './customer.service';
import { Router } from '@angular/router';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerAuthenticationService {
  customer: Customer;
  login:boolean;

  constructor(private service: CustomerService, private route: Router) {

  }

  authenticate(user: User) {
    this.service.verifyLogin(user);
    // .subscribe(data => {
    //   this.customer = data;
    //   if (this.customer.id > 0) {

    //     // sessionStorage.setItem("isCustomer", "true");
    //     // sessionStorage.setItem("isCustomerLogin", "true");
    //      alert("Login Successful");
    //     this.route.navigate(['customerhome']);
    //   }
    //   else {
    //     alert("Invalid Login!");
    //     console.log("INVALID CREDENTIALS!");
    //   }
    // });
  }
}
