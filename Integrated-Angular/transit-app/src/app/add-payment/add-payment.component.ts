import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer/customer.service';
import { Router } from '@angular/router';
import { Payment } from '../model/payment';
import { Booking } from '../model/booking';
import { Customer } from '../model/customer';
import { TransitService } from '../transit/transit.service';

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

  constructor(private transitService: TransitService, private service: CustomerService, private route: Router) { 
    this.getBooking();
  }
  
    
  ngOnInit() {
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
    this.transitService.getBooking().subscribe(book => this.book = book, err => this.err = err);
  }
}

