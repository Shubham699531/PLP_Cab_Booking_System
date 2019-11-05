import { Component, OnInit } from '@angular/core';
import { Driver } from '../model/driver';
import { Customer } from '../model/customer';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  driver : Driver;
  customer : Customer;

  role : String;
  email : String;
  password : String;
  invalidMsg: String = "";
  
  flag:boolean=false;

  constructor(public http:HttpClient, private route:Router) {
    this.customer= new Customer();
   }

  ngOnInit() {
  }

  login(){
  
    this.http.get<Customer>("http://localhost:8880/cabbooking/customer/" +this.email +"/"+ this.password).subscribe(data => this.customer =data);
   if(this.customer!= null)
     {this.flag= true;
     this.route.navigate(["home"]);
  }
     else{
     alert("User not found");
      }    }

}
