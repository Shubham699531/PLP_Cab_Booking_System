import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../_service/customer.service';
import { Vehicle } from '../model/vehicle.model';
import { Router } from '@angular/router';
import { CustomerRequest } from '../model/customer_requirement.model';
import { Booking } from '../model/booking.model';
import { Customer } from '../model/customer.model';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {

  showPriceComp:boolean = false;
  showBookingComp:boolean=true;
  showPastTripsComp:boolean=false;
  tripdetails:CustomerRequest;
  locations:String[] = [];
  fare:number;
  pastTrips : Booking[] = [];
  customer : Customer;
  cabDetails : Booking;
  constructor(private service : CustomerService, private route : Router) {
    this.customer = new Customer();
    this.cabDetails = new Booking();
    this.tripdetails = new CustomerRequest();
   }

  
  ngOnInit() {
    this.customer.name = sessionStorage.getItem("name");
    this.tripdetails = new CustomerRequest();
    this.service.getLocations().subscribe(p => this.locations=p);
  }

  estimatePrice(){
    if(this.tripdetails.model == "mini" || this.tripdetails.model == "micro" || this.tripdetails.model == "sedan")
      this.tripdetails.vehicleSize=4;
    else
      this.tripdetails.vehicleSize=6;
      // this.service.saveBooking(this.tripdetails).subscribe(p => this.tripdetails =p);
      this.showPriceComp=true;
      this.service.getEstimatePrice(this.tripdetails).subscribe(p => this.fare = p);
    
  }
  
  onConfirm(){
     this.tripdetails.customerId = this.service.getCustomerId().customerId;
     this.service.saveBookingRequest(this.tripdetails).subscribe(p => this.tripdetails =p);
     this.service.findACab(this.tripdetails).subscribe(c=>this.cabDetails=c);
     console.log(this.cabDetails.bookingId);
     
     this.route.navigate(['user']);
  }

  showBooking(){
    this.showBookingComp=true;
    this.showPastTripsComp=false;
  }

  showPastTrips(){
    this.showPastTripsComp=true;
    this.showBookingComp=false;
    this.showPriceComp=false;
    this.service.getPastTrips().subscribe(p=>this.pastTrips=p);
  }

  logout(){
    alert("Logout successfull!");
    this.route.navigate(['login']);
  }
 
}
