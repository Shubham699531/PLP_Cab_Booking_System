import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  invalidMsg : string;

  constructor() { }

  ngOnInit() {
    if(sessionStorage.getItem("userName") != null){
      sessionStorage.removeItem("userName");
      sessionStorage.removeItem("driverId");
      // sessionStorage.setItem("userName",null);
      // sessionStorage.setItem("driverId", null);
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
    }
  }

}
