import { Component, OnInit } from '@angular/core';
import { DriverService } from '../driver.service';
import { Booking } from '../model/booking.model';

@Component({
  selector: 'app-past-trips',
  templateUrl: './past-trips.component.html',
  styleUrls: ['./past-trips.component.css']
})
export class PastTripsComponent implements OnInit {
  driverId:number;
  history : Array<Booking> ;
  temporary : Booking[] = [];
  noBookingsMsg : String;
  noRides : boolean ;

  constructor(private service: DriverService) {}

  ngOnInit() {
    this.service.fetchAll(this.driverId).subscribe(data =>this.history=data);
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
