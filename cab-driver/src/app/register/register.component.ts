import { Component, OnInit } from '@angular/core';
import { DriverService } from '../driver.service';
import { CabDriver } from '../model/driver_model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  driver: CabDriver;

  constructor(private service: DriverService, private router : Router) { 
    this.driver = new CabDriver();
  }

  ngOnInit() {
  }

  addNewDriver(){
    this.service.addNewDriver(this.driver).subscribe(data =>{this.driver = data;
      if(this.driver.driverId > 0){
        sessionStorage.setItem("userName", this.driver.email);
        sessionStorage.setItem("driverId", this.driver.driverId.toString());
      }
      else{
        alert("Registration Unsuccessful!");
      }
   });
   if(sessionStorage.getItem("userName") != null){
      this.driver = new CabDriver();
      this.router.navigate(['/login']);
  }
  }

  getToday(): string {
    return new Date().toISOString().split('T')[0];
 }

 getMinDate(){
  return new Date("1900-01-01").toISOString().split('T')[0];
 }

}
