import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { CabDriver } from './model/driver_model';
import { User } from './model/user.model';
import { Booking } from './model/booking.model';

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  userName : String = "";

  constructor(private http: HttpClient) {
  }

  addNewDriver(driver: CabDriver){
   return this.http.post<CabDriver>("http://localhost:8881/front/save", driver);
  }

  fetchDriver(email: String){
    return this.http.get<CabDriver>("http://localhost:8881/front/fetch?email=" + email);
  }

  verifyLogin(user : User){
     return this.http.post<CabDriver>("http://localhost:8881/front/validate", user);
  }

  fetchAll(driverId : number){
    //driverId =1;
    return this.http.get<Booking[]>("http://localhost:8881/front/history?driverId=" + driverId);
  }
}
