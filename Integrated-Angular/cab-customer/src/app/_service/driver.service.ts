import { Injectable } from '@angular/core';
import { User } from '../model/user.model';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../model/customer.model';
import { Driver } from '../model/driver.model';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private http:HttpClient) { }

  verifyDriver(user:User){
    return this.http.post<Driver>("http://localhost:8180/cbs/loginDriver", user);
  }

  signup(driver:Driver){
    return this.http.post<Driver>("http://localhost:8180/cbs/signupDriver", driver);
  }
}
