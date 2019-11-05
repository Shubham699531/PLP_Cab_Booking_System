import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/booking.model';
import { CustomerService } from '../customer.service';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bookingDetails : Booking;
  user : User;
  customer  : Customer;
  constructor(private service : CustomerService) {
    this.bookingDetails=new Booking();
    this.user= new User();
    this.customer = new Customer();
   }

  ngOnInit() {
    this.user.email = "wwww";
    this.user.password = "wwww";
    this.user.role = "customer";
    
    this.service.getBookingDetails(this.user).subscribe(data=>this.bookingDetails = data);
    //this.bookingDetails = new Booking();
   
  }

  showBookingDetails(){
    
    // return this.bookingDetails;
  }

}
