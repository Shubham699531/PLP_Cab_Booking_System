import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from '../model/payment';
import { Booking } from '../model/booking.model';
import { Customer } from '../model/customer.model';
import { TransitService } from '../_service/transit.service';
import { CustomerService } from '../_service/customer.service';

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {

  book: Booking;
  cust: Customer;
  payment: Payment;
  found: boolean = false;
  err: any;
  custId: string;

  constructor(private transitService: TransitService, private service: CustomerService, private route: Router) { 
    this.custId = sessionStorage.getItem("customerId");
  }
  
    
  ngOnInit() {
    this.getBooking();
  }

  addPay() {
    this.service.savePayment(this.book).subscribe(data => this.payment = data);
    this.route.navigate(['add-report']);
  }

  checkBalance() {
    this.service.getCustomer(this.book).subscribe(data => {
      this.cust = data;
      if (this.cust == null)
        alert("Customer Not Found!");
      else {
        if (this.found == true) {
          this.cust.wallet = this.book.finalFare;
          this.addPay();
        }
        else if (this.cust.wallet < this.book.finalFare) {
          this.found = true;
          alert("Insufficient Wallet balance!");
        }
        else
          this.addPay();
      }
    });

  }
  getBooking() {

    this.transitService.getBooking(this.custId).subscribe(book => this.book = book, err => this.err = err);
  }
}

