import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';
import { Customer } from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  verifyAdmin(user:User):boolean{
    if(user.email == "admin" && user.password == "admin")
      return true;
    else
    return false;
  }
}
