import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/booking.model';
import { CustomerService } from '../customer.service';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';
import { CustomerRequirement } from '../model/customer_requirement.model';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bookingDetails : Booking;
  user : User;
  customer  : Customer;
  requirement : CustomerRequirement;
  notLoggedIn : boolean;
  constructor(private service : CustomerService) {
    this.bookingDetails=new Booking();
    this.user= new User();
    this.customer = new Customer();
    this.requirement = new CustomerRequirement();
    console.log("Booking component constructor()");
   }

  ngOnInit() {
    console.log("Booking component ngOnInit()")
    this.customer = this.service.getCustomer();
    if(this.customer.id>0){
      this.notLoggedIn = false;
      console.log("Customer" + this.customer.id);
      this.requirement.customerId = this.customer.id;  
      this.requirement.source = "Vikhroli";
      this.requirement.destination = "Ghatkopar";
      this.requirement.vehicleSize = 4;
      this.service.getBookingDetails(this.requirement).subscribe(data=>this.bookingDetails = data);
      console.log(this.bookingDetails.source);
    }
    else
      this.notLoggedIn = true;   
  }

  showBookingDetails(){
    
    // return this.bookingDetails;
  }

}
