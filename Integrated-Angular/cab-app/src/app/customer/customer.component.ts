import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  showBookCabComp:boolean=true;
  showPastTripsComp:boolean=false;
  showTripStatusComp:boolean=false;
  showAddPaymentComp:boolean=false;
  showAddReportComp:boolean=false;

  constructor(private route:Router) { }

  ngOnInit() {
  }

  showBooking(){
    this.showBookCabComp=true;
    this.showPastTripsComp=false;
    this.showTripStatusComp=false;
    this.showAddPaymentComp=false;
    this.showAddReportComp=false;

  }
  showPastTrips(){
    this.showBookCabComp=false;
    this.showPastTripsComp=true;
    this.showTripStatusComp=false;
    this.showAddPaymentComp=false;
    this.showAddReportComp=false;
  }
  showTripStatus(show){
    this.showBookCabComp=false;
    this.showPastTripsComp=false;
    this.showTripStatusComp=true;
    this.showAddPaymentComp=false;
    this.showAddReportComp=false;
  }

  showAddPayment(){
    this.showBookCabComp=false;
    this.showPastTripsComp=false;
    this.showTripStatusComp=false;
    this.showAddPaymentComp=true;
    this.showAddReportComp=false;
  }

  showAddReport(){
    this.showBookCabComp=false;
    this.showPastTripsComp=false;
    this.showTripStatusComp=false;
    this.showAddPaymentComp=false;
    this.showAddReportComp=true;
  }
  logout(){
    this.route.navigate(['login']);
  }
}
