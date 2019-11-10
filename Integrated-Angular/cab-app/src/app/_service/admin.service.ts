import { Injectable } from '@angular/core';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor() { }

  verifyLogin(user : User): boolean{
    console.log(user);
    if(user.email == "admin@mail.com"){
      if(user.password == "ouradmin"){
        return true;
      }

    }
  }
}
