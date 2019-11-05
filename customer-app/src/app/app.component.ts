import { Component } from '@angular/core';
import { CustomerService } from './customer.service';
import { User } from './model/user.model';
import { Customer } from './model/customer.model';
import { Router } from '@angular/router';
import { Booking } from './model/booking.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cbs-customer';
  isHidden : boolean;
  user : User;
  customer : Customer;
  book : Booking;
  invalidMsg : string;
  constructor(private service : CustomerService, private route : Router){
    this.isHidden = true;
  }

  ngOnInit() {
    this.user = new User();
    this.customer = new Customer();
    this.isHidden = true;
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
      this.isHidden=false;
      this.invalidMsg = '';
     // this.route.navigate(['customer_home']);
    }
    else{
      console.log("INVALID CREDENTIALS!");
      this.invalidMsg = "INVALID CREDENTIALS!";
    }
  }
 
}
