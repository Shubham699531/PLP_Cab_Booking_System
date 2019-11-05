import { Component, OnInit } from '@angular/core';
import { CbsService } from '../cbs/cbs.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../model/customer';
import { Driver } from '../model/driver';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  driver : Driver[]=[];
  customer : Customer[]=[];

  role : String;
  email : String;
  password : String;
  invalidMsg: String = "";
  
  flag:boolean=false;

  constructor(private service:CbsService) {
   //this.log = new Login();
   //this.role.push("Customer");
   //this.role.push("Driver");
   }

  ngOnInit() {
    
  }

  login(){
    if(this.role == "Customer")
     
    this.customer=this.service.loginUser(this.email, this.password);
    if(this.customer != null)
else
   this.service.loginDriver(this.email,this.password).subscribe(p =>this.driver = p);

  }



}
