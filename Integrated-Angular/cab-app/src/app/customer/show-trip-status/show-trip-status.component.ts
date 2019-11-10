import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';
import { CustomerService } from 'src/app/_service/customer.service';
import { Driver } from 'src/app/model/driver.model';
import { interval, Observable } from 'rxjs';
@Component({
  selector: 'app-show-trip-status',
  templateUrl: './show-trip-status.component.html',
  styleUrls: ['./show-trip-status.component.css']
})
export class ShowTripStatusComponent implements OnInit {
  driver : Driver;
  booking: Booking;
  showRating: boolean =false;
  //i : number;
  //timer:Observable<number> = interval(10000);
  constructor(private service: CustomerService) { 
    this.booking = new Booking();
    this.driver = new Driver();
  }

  //import { interval } from 'rxjs';

// Create an Observable that will publish a value on an interval
  //secondsCounter = interval(1000);
// Subscribe to begin publishing values

  ngOnInit() {
    this.booking.tripStatus = sessionStorage.getItem("bookingStatus");
    //this.secondsCounter.subscribe(n =>);
    
    if(this.booking.tripStatus == "confirmed"){
      this.service.findDriverById(+sessionStorage.getItem("driverId")).subscribe(data => this.driver=data);
    }
  }

  checkStatus(){
    this.service.checkBookingStatus(0).subscribe(data=>{this.booking = data;
    if(this.booking.tripStatus=='completed'){
      this.showRating = true;
    }
    });
  }

}
