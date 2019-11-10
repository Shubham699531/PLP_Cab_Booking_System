import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';
import { Router } from '@angular/router';
import { CustomerService } from '../_service/customer.service';
import { AdminService } from '../_service/admin.service';
import { DriverService } from '../_service/driver.service';
import { Driver } from '../model/driver.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User;
  customer:Customer;
  driver : Driver;

  constructor(private route:Router, private custService:CustomerService, private admService:AdminService, private driverService:DriverService) { 
    this.user = new User();
    this.customer = new Customer();
  }

  ngOnInit() {
  }

  verifyLogin(){
    if(this.user.role == "customer"){
      this.custService.verifyLogin(this.user).subscribe(data=>{this.customer=data;
       if(this.customer.customerId>0){
        sessionStorage.setItem("userName", this.customer.name);
        sessionStorage.setItem("userEmail", this.customer.email);
        sessionStorage.setItem("customerId", this.customer.customerId.toString());
        this.route.navigate(['customer']);
      }
      else{
        alert("Invalid Credentials!");
        this.user = new User();
      }
      });
       
    }
    if(this.user.role == "driver"){
      this.driverService.verifyLogin(this.user).subscribe(data=>{this.driver=data;
      if(this.driver!=null){
        sessionStorage.setItem("userName", this.driver.name);
        sessionStorage.setItem("userId", this.driver.driverId.toString());
        sessionStorage.setItem("userEmail", this.driver.email);
        alert("Login Successfull!");
        this.route.navigate(['driver']);
      }
      else{
        alert("Invalid Credentials!");
        this.user = new User();
      }
      });
    }

      if(this.user.role == "admin"){
        if(this.admService.verifyLogin(this.user)){
          alert("Login Successfull!");
          this.route.navigate(['admin']);
        }
        else{
          alert("Invalid Credentials!");
          this.user = new User();
        }

      }
    }
  registerDriver(){
    this.route.navigate(['driver-signup']);
  }

  registerUser(){
    this.route.navigate(['cust-signup']);

  }

}
