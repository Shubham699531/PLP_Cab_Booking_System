import { Component, OnInit } from '@angular/core';
import { Driver } from '../model/driver.model';
import { Vehicle } from '../model/vehicle.model';
import { DriverService } from '../_service/driver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-driver-signup',
  templateUrl: './driver-signup.component.html',
  styleUrls: ['./driver-signup.component.css']
})
export class DriverSignupComponent implements OnInit {
  driver: Driver;
  today: string;
  minDate : string;
  vehicle : Vehicle;
  locations : string[] = ["Powai","Andheri", "Juhu", "Airoli", "Kalwa", "Thane", "Kandivali", "Goregoan","Marol", "Oshiwara","Aarey Colony", "IIT Bombay", "Borivali", "Dombivili", "Mulund West", "SGNP", "Kanjurmarg East", "Ghansoli", "Mahape", "Charkop Gaon"];
  
  constructor(private service: DriverService, private router : Router) {
    this.locations.sort();
    this.driver = new Driver();
    this.vehicle = new Vehicle();
   }

  ngOnInit() {
    this.today = new Date().toISOString().split('T')[0];
    this.minDate = new Date("1900-01-01").toISOString().split('T')[0];
  }

  addNewDriver(){
    this.service.signup(this.driver).subscribe(data =>{this.driver = data;
      if(this.driver.driverId > 0){
        this. vehicle.vehicleNo = this.driver.vehicleNo;
        if(this.vehicle.model == "mini"){
          this.vehicle.categoryId = 1;
        }
        else if(this.vehicle.model == "micro"){
          this.vehicle.categoryId = 2;
        }
        else if(this.vehicle.model == "sedan"){
          this.vehicle.categoryId = 3;
        }
        else{
          this.vehicle.categoryId = 4;
        }
        sessionStorage.setItem("userName", this.driver.email);
        sessionStorage.setItem("driverId", this.driver.driverId.toString());
      }
      else{
        alert("Registration Unsuccessful!");
      }
   });
   if(sessionStorage.getItem("userName") != null){
      this.driver = new Driver();
      this.router.navigate(['login']);
  }
  }


}
