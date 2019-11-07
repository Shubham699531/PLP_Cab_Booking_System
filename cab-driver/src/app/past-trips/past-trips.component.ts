import { Component, OnInit } from '@angular/core';
import { DriverService } from '../driver.service';
import { Booking } from '../model/booking.model';
import { CabDriver } from '../model/driver_model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-past-trips',
  templateUrl: './past-trips.component.html',
  styleUrls: ['./past-trips.component.css']
})
export class PastTripsComponent implements OnInit {
  userName:String;
  history : Booking[] ;
  noRides : boolean ;
  invalidMsg : String ="";
  driver : CabDriver = new CabDriver();

  constructor(private service: DriverService, private router: Router) {
    
  }

  ngOnInit() {
    if(sessionStorage.getItem("userName") != null){
      //this.service.fetchDriver(sessionStorage.getItem("userName")).subscribe(data =>this.driver=data);
    //if(+sessionStorage.getItem("driverId") > 0){
      this.service.fetchAll(+sessionStorage.getItem("driverId")).subscribe(data =>{this.history=data;
      if(this.history.length == 0){
        this.invalidMsg = "No Rides Yet";
        this.noRides = true;
      }
    else{
      this.noRides = false;
    }
    });
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
      this.router.navigate(['login']);
    }
    
    
  }
  // show(){
  //   this.service.fetchAll(this.driverId).subscribe(data =>this.history=data);
  //   console.log(this.history);
  //   if(this.temporary.length == 0){
  //     this.noRides = true;
  //     this.noBookingsMsg = "No Past Bookings Yet";
  // }
  // else{
  //   this.noRides = false;
  //   this.history = this.temporary;
  // }     
  // }

}
