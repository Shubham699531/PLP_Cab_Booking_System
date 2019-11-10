import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';
import { Driver } from 'src/app/model/driver.model';
import { Router } from '@angular/router';
import { DriverService } from 'src/app/_service/driver.service';

@Component({
  selector: 'app-past-trips',
  templateUrl: './part-trips.component.html',
  styleUrls: ['./part-trips.component.css']
})
export class PastTripsComponent implements OnInit {
  userName:String;
  history : Booking[] ;
  noRides : boolean ;
  invalidMsg : String ="";
  driver : Driver = new Driver();

  constructor(private service: DriverService, private router: Router) {
    
  }

  ngOnInit() {
    if(sessionStorage.getItem("userEmail") != null){
      //this.service.fetchDriver(sessionStorage.getItem("userName")).subscribe(data =>this.driver=data);
    //if(+sessionStorage.getItem("driverId") > 0){
      console.log(sessionStorage.getItem("userEmail"));
      this.service.fetchPastTrips(+sessionStorage.getItem("driverId")).subscribe(data =>{this.history=data;
    //   if(this.history.length == 0){
    //     this.invalidMsg = "No Rides Yet";
    //     this.noRides = true;
    //     console.log("no rides");
    //   }
    // else{
    //   this.noRides = false;
    // }
    }, err=>this.invalidMsg=err);
    console.log(this.invalidMsg);
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
      console.log("not logged in");
      //this.router.navigate(['login']);
    }
    
    
  }
}
