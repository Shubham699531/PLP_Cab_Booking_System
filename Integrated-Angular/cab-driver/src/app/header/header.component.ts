import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  driverCheck : boolean = false;
  customerCheck : boolean = false;
  adminCheck : boolean = false;

  constructor() { }

  ngOnInit() {
    if(sessionStorage.getItem("userName") != null){
      if(sessionStorage.getItem("role") == "admin"){
        this.adminCheck = true;
      }
      else if(sessionStorage.getItem("role") == "customer"){
        this.customerCheck = true;
      }
      else if(sessionStorage.getItem("role") == "driver"){
        this.driverCheck = true;
      }
    }

  }

}
