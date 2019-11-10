import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Booking } from '../model/booking.model';
import { Driver } from '../model/driver.model';

@Injectable({
  providedIn: 'root'
})
export class TransitService {

  booking: Booking;
  driver: Driver;

  constructor(public http: HttpClient) { }

  startTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8810/transit/startTrip", booking);
  }

  endTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8810/transit/endTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  rateTrip(booking: Booking) {
    console.log(booking.rating);
    return this.http.post<Booking>("http://localhost:8810/transit/rateTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  getBooking(custId: string) {
    return this.http.get<Booking>("http://localhost:8810/transit/getBooking?customerId="+custId);
  }

  getDriver(driverId: number) {
    return this.http.get<Driver>("http://localhost:8810/transit/driver/" + driverId);
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
