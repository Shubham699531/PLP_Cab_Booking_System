import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer.model';
import { DatePipe } from '@angular/common';
import { Router } from '@angular/router';
import { CustomerService } from '../_service/customer.service';

@Component({
  selector: 'app-cust-signup',
  templateUrl: './cust-signup.component.html',
  styleUrls: ['./cust-signup.component.css']
})
export class CustSignupComponent implements OnInit {
  
  customer: Customer;
  signupSuccess: boolean;
  maxDate :string;

  constructor(private datePipe: DatePipe, private route:Router, private service: CustomerService) {
    this.customer = new Customer();
   }

  ngOnInit() {
    this.maxDate = this.datePipe.transform(new Date(new Date().setDate(new Date().getDate()-1)), 'yyyy-MM-dd');
    this.signupSuccess = false;
    console.log(this.maxDate);
  }

  addNewCustomer() {
    this.service.signUp(this.customer).subscribe(data => {this.customer=data;
      if(this.customer.email != null){
        sessionStorage.setItem("userName", this.customer.name);
        //sessionStorage.setItem("userId", this.customer.customerId.toString());
        sessionStorage.setItem("userEmail", this.customer.email);
        this.customer.wallet = 1000;
        alert("Login Sucessfull! Congrats! You were given Rs. 1000 in your wallet.");
        this.route.navigate(['login']);
      }
      else{
        alert("Sign Up Failed!");
        this.customer = new Customer();
      }
   
  });
  }
}
