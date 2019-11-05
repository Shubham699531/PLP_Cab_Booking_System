import { Component, OnInit } from '@angular/core';
import { Location } from '../model/location.model';
import { BookService } from '../book.service';
import { TripDetails } from '../model/tripdetails.model';

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css']
})
export class TripDetailsComponent implements OnInit {
  showPrice:boolean = false;
  tripdetails:TripDetails;
  locations:String[] = [];
  fare:number;

  constructor(private service:BookService) {
    this.tripdetails = new TripDetails();
    this.service.getLocations().subscribe(p => this.locations=p);
   }

  ngOnInit() {
   
  }

  estimatePrice(){
    if(this.tripdetails.model == "mini" || this.tripdetails.model == "micro" || this.tripdetails.model == "sedan")
      this.tripdetails.sizeOf=4;
    else
      this.tripdetails.sizeOf=6;
    this.service.saveBooking(this.tripdetails).subscribe(p => this.tripdetails =p);
    // this.service.sendTripDetails(this.tripdetails);
    // this.service.sendShowMessage(true);
    this.showPrice=true;
    console.log("1");
    this.service.getEstimetePrice(this.tripdetails).subscribe(p => this.fare = p);
    console.log("2");
  }

}
