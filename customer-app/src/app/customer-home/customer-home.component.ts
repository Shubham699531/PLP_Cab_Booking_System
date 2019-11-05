import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Vehicle } from '../model/vehicle.model';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {

  constructor(private service : CustomerService) { }

  locations : string[] = ["Thane","Juhu","Andheri","Versova"];
  ngOnInit() {
    
  }


}
