import { Component, OnInit } from '@angular/core';
import { TripDetails } from '../model/tripDetails';
import { Router } from '@angular/router';
import { Payment } from '../model/payment';
import { Booking } from '../model/booking.model';
import { Report } from '../model/report.model';
import { TransitService } from '../_service/transit.service';
import { CustomerService } from '../_service/customer.service';

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
  custId: string;

  constructor(private transitService: TransitService, private service: CustomerService, private route: Router) {
    this.custId = sessionStorage.getItem("customerId");
  }

  ngOnInit() {
    this.getBooking();
  }

  addRep() {
    this.service.saveReport(this.book).subscribe(data => this.report = data);
    this.report = new Report();
    this.route.navigate(['tripEnded']);
  }

  getBooking() {
    this.transitService.getBooking(this.custId).subscribe(book => this.book = book, err => this.err = err);
  }
}
