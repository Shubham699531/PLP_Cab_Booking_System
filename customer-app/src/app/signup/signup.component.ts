import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer.model';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  customer : Customer;
  signupSuccess : boolean;
  constructor(private service : CustomerService, private route : Router) {
    this.customer = new Customer();
   }

  ngOnInit() {
    this.signupSuccess = false;
  }

  addNewCustomer(){
    console.log(this.customer.email);
    this.service.registerCustomer(this.customer).subscribe(data=>this.customer=data);
    if(this.customer.id>0){
      this.signupSuccess = true;
      console.log("Signup successfull");
      this.route.navigate(['login']);
    }
    else{
      this.signupSuccess = false;
      console.log("Signupfailed");
    }
  }
}
