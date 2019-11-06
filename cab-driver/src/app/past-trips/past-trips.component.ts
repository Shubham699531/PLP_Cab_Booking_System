import { Component, OnInit } from '@angular/core';
import { DriverService } from '../driver.service';
import { Booking } from '../model/booking.model';
import { CabDriver } from '../model/driver_model';

@Component({
  selector: 'app-past-trips',
  templateUrl: './past-trips.component.html',
  styleUrls: ['./past-trips.component.css']
})
export class PastTripsComponent implements OnInit {
  userName:String;
  history : Booking[] ;
  noBookingsMsg : String;
  noRides : boolean ;
  invalidMsg : String ="";
  driver : CabDriver = new CabDriver();

  constructor(private service: DriverService) {
    
  }

  ngOnInit() {
    console.log(this.service.userName);
    this.service.fetchDriver(this.service.userName).subscribe(data=>this.driver=data);
    console.log(this.driver.driverId)
    if(this.driver.driverId >0){
      this.service.fetchAll(this.driver.driverId).subscribe(data =>this.history=data);
    }
    else{
      this.invalidMsg = "No Rides Yet";
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
