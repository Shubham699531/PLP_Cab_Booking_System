import { Injectable } from '@angular/core';
import { Driver } from '../model/driver.model';
import { User } from '../model/user.model';
import { Booking } from '../model/booking.model';
import {HttpClient} from '@angular/common/http';
import { throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Vehicle } from '../model/vehicle.model';
import { Customer } from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  currentUser : Driver = new Driver();

  constructor(private http: HttpClient) {
  }

  // addNewDriver(driver: Driver){
  //  return this.http.post<Driver>("http://localhost:8881/front/save", driver);
  // }

  // addVehicle(vehicle : Vehicle){
  //   return this.http.post<Vehicle>("http://localhost:8180/cbs/saveVehicle", vehicle);
  // }

  verifyLogin(user : User){
    //http://localhost:8180/cbs/loginCustomer
    return this.http.post<Driver>("http://localhost:8180/cbs/loginDriver", user);
  }

  signUp(driver: Driver){
    //http://localhost:8180/cbs/signupCustomer
    return this.http.post<Driver>("http://localhost:8180/cbs/signupDriver", driver);
  }

  saveVehicle(vehicle: Vehicle){
    //http://localhost:8180/cbs/saveVehicle
    return this.http.post<Vehicle>("http://localhost:8180/cbs/saveVehicle", vehicle);
  }
  fetchDriver(email: String){
    return this.http.get<Driver>("http://localhost:8180/cbs/fetchDriverByEmail?email=" + email);
  }

  // verifyLogin(user : User){
  //    return this.http.post<Driver>("http://localhost:8881/front/validate", user);
  // }

  fetchPastTrips(driverId : number){
    //driverId =1;
    return this.http.get<Booking[]>("http://localhost:8180/cbs/pastTripsDriver?driverId=" + driverId).pipe(retry(1),catchError(this.errorHandler));
  }

  //Transit
  startTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8180/cbs/startTrip", booking);
  }

  endTrip(booking: Booking) {
    return this.http.post<Booking>("http://localhost:8180/cbs/endTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  rateTrip(booking: Booking) {
    console.log(booking.rating);
    return this.http.post<Booking>("http://localhost:8180/cbs/rateTrip", booking).pipe(retry(1), catchError(this.errorHandler));
  }

  // getBooking() {
  //   return this.http.get<Booking>("http://localhost:8880/driver/book");
  // }

  getCurrentBooking(driverId : number){
    return this.http.get<Booking>("http://localhost:8180/cbs/getBookingForADriver?driverId=" + driverId);
  }

  getCustomerDetail(driverId : number){
    return this.http.get<Customer>("http://localhost:8180/cbs/getCustomerFromBooking?driverId=" + driverId);
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
