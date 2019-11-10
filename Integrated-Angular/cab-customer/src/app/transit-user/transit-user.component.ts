import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { interval } from 'rxjs';
import { switchMap, startWith, takeWhile } from 'rxjs/operators';
import { Booking } from '../model/booking.model';
import { Driver } from 'selenium-webdriver/chrome';
import { TransitService } from '../_service/transit.service';

@Component({
  selector: 'app-transit-user',
  templateUrl: './transit-user.component.html',
  styleUrls: ['./transit-user.component.css']
})
export class TransitUserComponent implements OnInit {
  custId: string;
  rating: number = 0;
  booking: Booking;
  err: any;
  started: boolean = false;
  completed: string = "Completed";
  rated: string = "Rated";
  driver: Driver;

  constructor(private transitService: TransitService, private route: Router) {
    this.custId = sessionStorage.getItem("customerId");

  }

  ngOnInit() {
    interval(1000).pipe(
      startWith(0), switchMap(() => this.transitService.getBooking(this.custId)))
      .subscribe(book => this.booking = book, err => this.err = err);
  }

  counter(num1: number, num2: number) {
    return new Array(num2 - num1).fill(0).map((x, i) => num1 + i);
  }

  setRating() {
    this.booking.rating = this.rating;
    this.transitService.rateTrip(this.booking).subscribe(book => this.booking = book, err => this.err = err);
    console.log(this.booking.tripStatus);
  }

  payment() {
    this.route.navigate(['add-payment']);
  }
}
