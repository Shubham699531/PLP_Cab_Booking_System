import { Component, OnInit } from '@angular/core';
import { Driver } from 'src/app/model/driver.model';
import { Router } from '@angular/router';
import { DriverService } from 'src/app/_service/driver.service';

@Component({
  selector: 'app-about-driver',
  templateUrl: './about-driver.component.html',
  styleUrls: ['./about-driver.component.css']
})
export class AboutDriverComponent implements OnInit {
  driver: Driver;
  email : string ;
  loggedIn : boolean =false;
  invalidMsg : string;

  constructor(private service: DriverService, private router:Router) { 
    this.driver = new Driver();
  }

  ngOnInit() {

    if(sessionStorage.getItem("userEmail") != null){
      console.log("HIIIIIIIIIIII" + sessionStorage.getItem("userEmail"));
      this.service.fetchDriver(sessionStorage.getItem("userEmail")).subscribe(data =>{this.driver=data;
      console.log("ADDDDDDD" + this.driver.email)});
      this.loggedIn = true;
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
      //this.router.navigate(['login']);
    }
    //this.service.getDriverByEmail(sessionStorage.getItem("useEmail"));
  }

}
