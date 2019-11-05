import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { CabDriver } from './model/driver_model';
import { User } from './model/user.model';
import { Driver } from 'selenium-webdriver/safari';
import { Booking } from './model/booking.model';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  driver : CabDriver;

  constructor(private http: HttpClient) { 
    this.driver = new CabDriver();
  }

  addNewDriver(driver: CabDriver){
   return this.http.post("http://localhost:8881/front/save", driver);
  }

  fetchDriver(email: String){
    return this.http.get<CabDriver>("http://localhost:8881/front/fetch?email=" + email);
  }

  verifyLogin(user : User){
     return this.http.post<CabDriver>("http://localhost:8881/front/validate", user);
  }

  fetchAll(driverId : number){
    driverId =1;
    return this.http.get<Booking[]>("http://localhost:8881/front/history?driverId=" + driverId);
  }
}
