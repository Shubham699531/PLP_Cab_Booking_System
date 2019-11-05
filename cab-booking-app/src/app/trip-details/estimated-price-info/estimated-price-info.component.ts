import { Component, OnInit } from '@angular/core';
import { TripService } from 'src/app/trip.service';
import { TripDetails } from 'src/app/model/tripdetails.model';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-estimated-price-info',
  templateUrl: './estimated-price-info.component.html',
  styleUrls: ['./estimated-price-info.component.css']
})
export class EstimatedPriceInfoComponent implements OnInit {
  details:TripDetails;
  show:boolean;
  constructor(private service:BookService) { }

  ngOnInit() {
    this.service.tripdetails$
      .subscribe(
        message => this.details=message
      );
      // console.log(this.details.userId);
  }

//  toggle(){
//   this.service.tripdetails$
//   .subscribe(
//     message => this.details=message
//   );
//  }

}
