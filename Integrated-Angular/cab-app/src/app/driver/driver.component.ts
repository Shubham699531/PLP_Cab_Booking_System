import { Component, OnInit } from '@angular/core';
import { Driver } from '../model/driver.model';
import { Router } from '@angular/router';
import { DriverService } from '../_service/driver.service';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {
  driver: Driver;
  email : string ;
  isHidden : boolean =true;
  invalidMsg : string;

  showAboutDriverComp:boolean=true;
  showPastTripsComp:boolean=false;
  showTripStatusComp:boolean=false;
  

  constructor(private service: DriverService, private route:Router) { 
    this.driver = new Driver();
  }

  ngOnInit() {

    if(sessionStorage.getItem("userName") != null){
      console.log("HIIIIIIIIIIII" + sessionStorage.getItem("userName"));
      this.service.fetchDriver(sessionStorage.getItem("userName")).subscribe(data =>{this.driver=data;
      console.log("ADDDDDDD" + this.driver.email)});
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
      //this.route.navigate(['login']);
    }
    
  }

  showAboutDriver(){
    this.showAboutDriverComp=true;
    this.showPastTripsComp=false;
    this.showTripStatusComp=false;

  }
  showPastTrips(){
    this.showAboutDriverComp=false;
    this.showPastTripsComp=true;
    this.showTripStatusComp=false;
  }
  showTripStatus(){
    this.showAboutDriverComp=false;
    this.showPastTripsComp=false;
    this.showTripStatusComp=true;
  }
  logout(){
    this.route.navigate(['login']);
  }

  
}
