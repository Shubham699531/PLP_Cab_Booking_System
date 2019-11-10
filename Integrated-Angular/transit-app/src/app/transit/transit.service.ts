import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Booking } from '../model/booking';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Driver } from '../model/driver';

@Injectable({
  providedIn: 'root'
})
export class TransitService {

  booking: Booking;
  driver: Driver;

  constructor(public http: HttpClient) { }

  startTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8880/driver/startTrip", booking);
  }

  endTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8880/driver/endTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  rateTrip(booking: Booking) {
    console.log(booking.rating);
    return this.http.post<Booking>("http://localhost:8880/driver/rateTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  getBooking() {
    return this.http.get<Booking>("http://localhost:8880/driver/book");
  }

  getDriver(driverId: number) {
    return this.http.get<Driver>("http://localhost:8880/driver/driver/" + driverId);
  }

  errorHandler(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      //client side error
      errorMessage = `Error: ${error.error.message}`;
    }
    else {
      //server side error
      errorMessage = `Error Code : ${error.status}\nMessage: ${error.error}`;
    }
    window.alert(errorMessage);
    return throwError(error)
  }
}
