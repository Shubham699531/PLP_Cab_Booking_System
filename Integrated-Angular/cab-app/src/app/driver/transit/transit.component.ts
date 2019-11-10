import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';
import { Driver } from 'src/app/model/driver.model';
import { DriverService } from 'src/app/_service/driver.service';
import { Router } from '@angular/router';
import { of, interval } from 'rxjs';
import { takeWhile, startWith, switchMap } from 'rxjs/operators';
import { Customer } from 'src/app/model/customer.model';

@Component({
  selector: 'app-transit',
  templateUrl: './transit.component.html',
  styleUrls: ['./transit.component.css']
})
export class TransitComponent implements OnInit {
  booking: Booking;
  err: any;
  confirmedTrip:boolean=false;
  started: boolean = false;
  completed: boolean = false;
  driver: Driver;
  i:number = 0;
  customer: Customer;
  // timers$=of(this.counter(0,100));

  constructor(private driverService: DriverService,private route:Router) {
    this.customer = new Customer();
    this.booking = new Booking();
  }

  ngOnInit() {
    this.getBooking();

  }

  counter(num1: number) {
    return num1+1;
  }

  timer(){
    interval(1000).pipe(startWith(0), switchMap(() => of(this.counter(this.i))), 
    takeWhile(a=>!(this.completed))).subscribe(i => this.i =i);
  }
  getBooking() {
    this.driverService.getCurrentBooking(+sessionStorage.getItem("userId")).subscribe(book => this.booking = book, err => this.err = err);
    //this.booking.finalTime=0;
    console.log(this.booking.customerId + "cs" + this.booking.bookingId + +sessionStorage.getItem("userId"));
    if(this.booking.customerId>0){
      this.driverService.getCustomerDetail(+sessionStorage.getItem("userId")).subscribe(customer=>this.customer=customer, err=>this.err=err);
      this.confirmedTrip = true;
    }
  }
  
  startTrip() {
    this.driverService.startTrip(this.booking).subscribe(book => this.booking = book, err => this.err = err);
    this.started = true;
    this.timer();
  }

  endTrip(){
    this.booking.finalTime=this.i;
    this.completed = true;
    this.started = false;
    this.driverService.endTrip(this.booking).subscribe(book => this.booking = book, err => this.err = err);
    //this.driverService.getDriver(this.booking.driverId).subscribe(driver => this.driver = driver, err => this.err = err);
  }
}
