import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../_service/customer.service';

@Component({
  selector: 'app-trip-ended',
  templateUrl: './trip-ended.component.html',
  styleUrls: ['./trip-ended.component.css']
})
export class TripEndedComponent implements OnInit {

  constructor(private service:CustomerService, private route:Router) { }

  ngOnInit() {
  }

  addCompletion(){
    this.route.navigate(['tripEnded']);
  }
}
