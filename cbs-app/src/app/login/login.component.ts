import { Component, OnInit } from '@angular/core';
import { CbsService } from '../cbs/cbs.service';
import { Customer } from '../model/customer';
import { Driver } from '../model/driver';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  driver : Driver;
  customer : Customer;

  role : String;
  email : String;
  password : String;
  invalidMsg: String = "";
  
  flag:boolean=false;

  constructor(public http:HttpClient, private route:Router) {
   this.driver = new Driver();
   
   }

  ngOnInit() {
    
  }


loginUser(){
  
  this.http.get<Driver>("http://localhost:8880/cabbooking/driver/" +this.email +"/"+ this.password).subscribe(data => this.driver =data);
 if(this.driver != null)
   {this.flag= true;
   this.route.navigate(["home"]);
}
   else{
   alert("User not found");
    }
  }



}
