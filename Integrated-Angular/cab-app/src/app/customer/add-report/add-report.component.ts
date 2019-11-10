import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';
import { Payment } from 'src/app/model/payment';
import { Report } from 'src/app/model/report.model';

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {
  book: Booking;
  payment: Payment;
  report: Report;

  constructor() { }

  ngOnInit() {
  }

  addRep(){
    
  }
}
