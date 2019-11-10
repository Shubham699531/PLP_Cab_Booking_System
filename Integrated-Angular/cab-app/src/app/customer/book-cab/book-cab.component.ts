import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';
import { Customer } from 'src/app/model/customer.model';
import { Router } from '@angular/router';
import { CustomerRequest } from 'src/app/model/customer_requirement.model';
import { CustomerService } from 'src/app/_service/customer.service';

@Component({
  selector: 'app-book-cab',
  templateUrl: './book-cab.component.html',
  styleUrls: ['./book-cab.component.css']
})
export class BookCabComponent implements OnInit {
  showPriceComp:boolean = false;
  tripdetails:CustomerRequest;
  locations:String[] = []; //['Airoli','Marol','Ghansoli','Ghatkopar','Andheri'];
  fare:number;
  customer : Customer;
  cabDetails : Booking;
  @Output() showTripStatus = new EventEmitter();

  constructor(private route:Router, private service: CustomerService) { 
    this.customer = new Customer();
    this.cabDetails = new Booking();
    this.tripdetails = new CustomerRequest();
  }

  ngOnInit() {
    this.tripdetails = new CustomerRequest();
    this.service.getLocations().subscribe(p => this.locations=p);

  }

  estimatePrice(){
    this.service.saveBooking(this.tripdetails).subscribe(p => this.tripdetails =p);
    this.service.getEstimatePrice(this.tripdetails).subscribe(p => this.fare = p);
    this.showPriceComp=true;
  }
  
  onConfirm(){
    //  this.tripdetails.customerId = this.service.getCustomerId().customerId;
    //this.service.saveBookingRequest(this.tripdetails).subscribe(p => this.tripdetails =p);
    this.tripdetails.customerId=+sessionStorage.getItem("customerId");
    this.service.findACab(this.tripdetails).subscribe(c=>{this.cabDetails=c;
    console.log(this.cabDetails);
    //  console.log(this.cabDetails.bookingId);
     
    //  this.route.navigate(['user']);
    this.showTripStatus.emit("true");
    sessionStorage.setItem("bookingStatus",this.cabDetails.tripStatus);
    sessionStorage.setItem("driverId",this.cabDetails.driverId.toString());
  });
    this.route.navigate(['customer']);
    this.showPriceComp=false;
  }


}
