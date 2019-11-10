import { Component, OnInit } from '@angular/core';
import { TripDetails } from '../model/tripDetails';
import { CustomerService } from '../customer/customer.service';
import { Router } from '@angular/router';
import { Payment } from '../model/payment';
import { Report } from '../model/report';
import { Booking } from '../model/booking';
import { TransitService } from '../transit/transit.service';

@Component({
  selector: 'app-add-report',
  templateUrl: './add-report.component.html',
  styleUrls: ['./add-report.component.css']
})
export class AddReportComponent implements OnInit {

  book: Booking;
  err: any;
  payment: Payment;
  report: Report;

  constructor(private transitService: TransitService, private service: CustomerService, private route: Router) { 
    this.getBooking();
  }

  ngOnInit() {
 }

  addRep() {
    this.service.saveReport(this.book).subscribe(data => this.report = data);
    this.report = new Report();
    this.route.navigate(['tripEnded']);
  }

  getBooking() {
    this.transitService.getBooking().subscribe(book => this.book = book, err => this.err = err);
  }
}
