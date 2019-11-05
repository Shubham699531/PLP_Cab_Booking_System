import { Component, OnInit } from '@angular/core';
import { TripDetails } from 'src/app/model/tripdetails.model';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-cab-booking-form',
  templateUrl: './cab-booking-form.component.html',
  styleUrls: ['./cab-booking-form.component.css']
})
export class CabBookingFormComponent implements OnInit {
  tripdetails:TripDetails;
  locations:String[] = [];
  fare:number;
  constructor(private service:BookService) { }

  ngOnInit() {
    this.tripdetails = new TripDetails();
    this.service.getLocations().subscribe(p => this.locations=p);
  }

  estimatePrice(){
    if(this.tripdetails.model == "mini" || this.tripdetails.model == "micro" || this.tripdetails.model == "sedan")
      this.tripdetails.sizeOf=4;
    else
      this.tripdetails.sizeOf=6;
    this.service.saveBooking(this.tripdetails).subscribe(p => this.tripdetails =p);
    this.service.sendTripDetails(this.tripdetails);
    this.service.sendShowMessage(true);
  }
}
