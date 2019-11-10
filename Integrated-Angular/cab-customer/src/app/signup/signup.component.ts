import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer.model';
import { CustomerService } from '../_service/customer.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  customer: Customer;
  signupSuccess: boolean;
  maxDate :string;
  constructor(private service: CustomerService, private route: Router, private datePipe: DatePipe) {
    this.customer = new Customer();
  }

  ngOnInit() {
    this.maxDate = this.datePipe.transform(new Date(new Date().setDate(new Date().getDate()-1)), 'yyyy-MM-dd');
    this.signupSuccess = false;
    console.log(this.maxDate);
  }

  addNewCustomer() {
    console.log(this.customer.email);
    this.customer.wallet = 1000;
    this.customer.customerId = 0;
    this.service.registerCustomer(this.customer).subscribe(data => {
    this.customer = data
      if (this.customer.customerId > 0) {
        this.signupSuccess = true;
        this.route.navigate(['login']);
      }
      else {
        this.signupSuccess = false;
        console.log("Signupfailed");
      }
      error => alert("Customer already exists!");
    });

  }
}
