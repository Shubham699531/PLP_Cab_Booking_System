import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer';
import { CbsService } from '../cbs/cbs.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-regcustomer',
  templateUrl: './regcustomer.component.html',
  styleUrls: ['./regcustomer.component.css']
})
export class RegcustomerComponent implements OnInit {

  customer: Customer;


  constructor(private service: CbsService,private route:Router) { 
    this.customer = new Customer();
  }

  ngOnInit() {
  }

  saveCustomer(){
    this.service.saveCustomer(this.customer).subscribe();
    this.customer = new Customer();
    this.route.navigate(['/home']);
  }


}
