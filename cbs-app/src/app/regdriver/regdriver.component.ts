import { Component, OnInit } from '@angular/core';

import { CbsService } from '../cbs/cbs.service';
import { Driver } from '../model/driver';

@Component({
  selector: 'app-regdriver',
  templateUrl: './regdriver.component.html',
  styleUrls: ['./regdriver.component.css']
})
export class RegdriverComponent implements OnInit {

  driver: Driver;
  models : String[] = [];

  constructor(private service:CbsService) {
    this.driver = new Driver();
    this.models.push("Mini");
    this.models.push("Micro");
    this.models.push("Sedan");
    this.models.push("SUV");

   }

  ngOnInit() {
  }

  saveDriver(){
    this.service.saveDriver(this.driver).subscribe();
    this.driver = new Driver();
    //this.route.navigate(['find']);
  }
                       

}
