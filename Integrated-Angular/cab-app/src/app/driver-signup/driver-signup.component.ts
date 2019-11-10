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
  model : string;
  today: string;
  minDate : string;
  vehicle : Vehicle;
  locations : string[] = ["Powai","Andheri", "Juhu", "Airoli", "Kalwa", "Thane", "Kandivali", "Goregoan","Marol", "Oshiwara","Aarey Colony", "IIT Bombay", "Borivali", "Dombivili", "Mulund West", "SGNP", "Kanjurmarg East", "Ghansoli", "Mahape", "Charkop Gaon"];

  constructor(private service: DriverService, private route: Router) { 
    this.locations.sort();
    this.driver = new Driver();
    this.vehicle = new Vehicle();
 }

  ngOnInit() {
    this.today = new Date().toISOString().split('T')[0];
    this.minDate = new Date("1900-01-01").toISOString().split('T')[0];

  }
  addNewDriver(){

     this.service.signUp(this.driver).subscribe(data => {this.driver=data;});

     this.vehicle.vehicleNo = this.driver.vehicleNo;
     this.vehicle.model = this.model;
     this.vehicle.status = "free";
     if(this.model == "mini"){
       this.vehicle.categoryId = 1;
     }
     else if(this.model == "micro"){
       this.vehicle.categoryId = 2;
     }
     else if(this.model == "sedan"){
       this.vehicle.categoryId = 3;
     }
     else{
       this.vehicle.categoryId = 4;
     }
     console.log(this.vehicle.categoryId);
     this.service.saveVehicle(this.vehicle).subscribe(data=>{this.vehicle = data; console.log(this.vehicle.categoryId);});
     if(this.vehicle != null){
      alert("SignUp Successfull!");
     }

    this.route.navigate(['/login']);
}
}
