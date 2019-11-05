import { Injectable } from '@angular/core';
import { Customer } from '../model/customer';
import { Driver} from '../model/driver';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CbsService {

  constructor(public http:HttpClient) { }

  saveCustomer(cst : Customer){
    return this.http.post<Customer>("http://localhost:8880/cabbooking/addCustomer", cst);

  }

  saveDriver(drv : Driver){
    return this.http.post<Driver>("http://localhost:8880/cabbooking/addDriver", drv);

  }

  loginUser(email: String,password: String){
   
      return this.http.get<Customer[]>("http://localhost:8880/cabbooking/customer/"+email+password);
      
    }
 loginDriver(email: String,password: String){

      return this.http.get<Driver[]>("http://localhost:8880/cabbooking/driver/"+email+password);
      
    }
  }

  

