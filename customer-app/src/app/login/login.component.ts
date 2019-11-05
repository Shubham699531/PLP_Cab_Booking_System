import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
import { Booking } from '../model/booking.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user : User;
  customer : Customer;
  book : Booking
  invalidMsg : string;

  constructor(private service : CustomerService, private route : Router){
    this.user = new User();
    this.customer = new Customer();
  }

  ngOnInit() {
  }

  verifyLogin(){
    this.service.verifyLogin(this.user).subscribe(data=>this.customer=data);
    
    console.log(this.user.role);
    console.log(this.customer.id);
    // if(this.user.email=="www"){
    //   this.customer = new Customer();
    //   this.customer.email = this.user.email;
    // }
    if(this.customer.id>0){
      console.log("login successfull");
      //this.isHidden=false;
      this.invalidMsg = '';
      this.route.navigate(['customer_home']);
    }
    else{
      console.log("INVALID CREDENTIALS!");
      this.invalidMsg = "INVALID CREDENTIALS!";
    }
  }
}
