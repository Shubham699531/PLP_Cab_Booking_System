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
  isHiddenLogin : boolean;
  isHiddenCustomerDashboard : boolean;
  
  constructor(private route : Router){
    this.isHiddenLogin = false;
    this.isHiddenCustomerDashboard = true;
    console.log("App component constructor()");
  }

  ngOnInit() {
    console.log("App component ngOnInit()");
  }

  
 
}
