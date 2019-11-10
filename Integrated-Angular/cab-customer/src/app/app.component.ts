import { Component } from '@angular/core';
import { CustomerService } from './_service/customer.service';
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
  isAdmin:boolean=false;
  
  constructor(private route : Router){
      }

  ngOnInit() {
    if(sessionStorage.getItem("isAdmin")=="true")
      this.isAdmin = true;
   
  }

  
 
}
