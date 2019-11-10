import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../_service/customer.service';
import { Customer } from '../model/customer.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cust-signup',
  templateUrl: './cust-signup.component.html',
  styleUrls: ['./cust-signup.component.css']
})
export class CustSignupComponent implements OnInit {
  customer:Customer;

  constructor(private cService:CustomerService, private route:Router) {
    console.log("DDDDDDDDD");
   }

  ngOnInit() {
    console.log("DDDDDDDDD");
  }

  addNewCustomer(){
    this.cService.registerCustomer(this.customer).subscribe(data => {
      this.customer = data;
      if(this.customer.customerId>0){
        alert("Signup successfull!");
        this.route.navigate(['login']);
      }
      else{
        alert("Signup Failed!");
        this.route.navigate(['cust-signup']);
      }
    });
  }

}
