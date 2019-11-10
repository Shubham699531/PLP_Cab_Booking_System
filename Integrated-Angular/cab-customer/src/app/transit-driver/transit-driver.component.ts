import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { of, interval } from 'rxjs';
import { takeWhile, startWith, switchMap } from 'rxjs/operators';
import { Booking } from '../model/booking.model';
import { TransitService } from '../_service/transit.service';
import { Driver } from '../model/driver.model';

@Component({
  selector: 'app-transit-driver',
  templateUrl: './transit-driver.component.html',
  styleUrls: ['./transit-driver.component.css']
})
export class TransitDriverComponent implements OnInit {

  booking: Booking;
  err: any;
  started: boolean = false;
  completed: boolean = false;
  driver: Driver;
  i:number = 0;
  // timers$=of(this.counter(0,100));

  constructor(private transitService: TransitService,private route:Router) {
    this.getBooking();
  }

  ngOnInit() {
  }

  counter(num1: number) {
    return num1+1;
  }

  timer(){
    interval(1000).pipe(startWith(0), switchMap(() => of(this.counter(this.i))), 
    takeWhile(a=>!(!this.started || this.completed))).subscribe(i=>this.i=i);
  }
  getBooking() {
    //To be updated
    this.transitService.getBooking("10").subscribe(book => this.booking = book, err => this.err = err);
  }

  startTrip() {
    this.transitService.startTrip(this.booking).subscribe(book => this.booking = book, err => this.err = err);
    this.started = true;
    this.timer();
  }

  endTrip(){
    this.booking.finalTime=this.i;
    this.completed = true;
    this.transitService.endTrip(this.booking).subscribe(book => this.booking = book, err => this.err = err);
    this.transitService.getDriver(this.booking.driverId).subscribe(driver => this.driver = driver, err => this.err = err);
  }
}
