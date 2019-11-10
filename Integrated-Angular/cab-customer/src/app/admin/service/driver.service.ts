import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Driver } from '../model/driver.model';
import { Observable } from 'rxjs';
import { Report } from '../model/report.model';



@Injectable({
  providedIn: 'root'
})
export class DriverService {
  drivers:Driver[]=[];
  reports:Report[]=[];
 driver:Driver;
 report: Report;
  
  constructor(public http:HttpClient) { }
  
  

 deleteDriver(id: number) {
  return this.http.get("http://localhost:8888/admin/remove/"+id);
}

  saveDriver(driver: Driver){
     return this.http.post<any>("http://localhost:8888/admin/saveDriver", driver);
 
   }
  
   listDriver():Observable<any>{
  
    return this.http.get("http://localhost:8888/admin/getAllDrivers");
  }


  findDriver(id: number): Observable<Driver> {
    return this.http.get<Driver>("http://localhost:8888/admin/driver/" + id);
  }
  

   updateDriver(driver: Driver) {
    return this.http.post("http://localhost:8888/admin/updateDriver", driver);
  }
 

  listReports():Observable<any>{
    return this.http.get("http://localhost:8888/admin/report");
  }
  listBooking():Observable<any>{
    return this.http.get("http://localhost:8888/admin/getAllBooking");
  }
  
  

   set(driver: Driver){
     this.driver= driver;
   }
   get(){
     return this.driver;
    
   }
  setter(report: Report){
    this.report= report;
    console.log(report);
  }
  getter(){
    return this.report;
   
  }
}