import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';
import { CustomerService } from '../_service/customer.service';
import { Router } from '@angular/router';
import { Booking } from '../model/booking.model';
import { CustomerAuthenticationService } from '../_service/customer-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  customer: Customer;
  book: Booking

  constructor(private cauthenticate: CustomerAuthenticationService, private route: Router, private service: CustomerService) {
    this.user = new User();
    this.customer = new Customer();
  }

  ngOnInit() {
    this.user.role = "customer";
  }

  verifyLogin() {
    //this.cauthenticate.authenticate(this.user);
    this.service.verifyLogin(this.user).subscribe(data => {
      this.customer = data;
      if (this.customer.customerId > 0) {
        sessionStorage.setItem("customerId",this.customer.customerId.toString())
        sessionStorage.setItem("name",this.customer.name);
        // sessionStorage.setItem("isCustomer", "true");
        // sessionStorage.setItem("isCustomerLogin", "true");
         alert("Login Successful");
        this.route.navigate(['customerhome']);
      }
      else {
        alert("Invalid Login!");
        console.log("INVALID CREDENTIALS!");
      }
    });
  }

  signup() {
    this.route.navigate(['signup']);
  }
}
