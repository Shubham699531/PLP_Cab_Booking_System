import { Component, OnInit } from '@angular/core';
import { Customer } from '../model/customer';
import { CbsService } from '../cbs/cbs.service';

@Component({
  selector: 'app-regcustomer',
  templateUrl: './regcustomer.component.html',
  styleUrls: ['./regcustomer.component.css']
})
export class RegcustomerComponent implements OnInit {

  customer: Customer;


  constructor(private service: CbsService) { 
    this.customer = new Customer();
  }

  ngOnInit() {
  }

  addNewCustomer(){
    this.service.saveCustomer(this.customer).subscribe();
    this.customer = new Customer();
    //this.router.navigate(['/home']);
  }


}
