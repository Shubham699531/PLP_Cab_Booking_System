import { Component, OnInit } from '@angular/core';
import { CabDriver } from '../model/driver_model';
import { DriverService } from '../driver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  driver: CabDriver;
  email : string ;
  isHidden : boolean =true;
  invalidMsg : string;

  constructor(private service: DriverService, private router:Router) { 
    this.driver = new CabDriver();
  }

  ngOnInit() {

    if(sessionStorage.getItem("userName") != null){
      this.service.fetchDriver(sessionStorage.getItem("userName")).subscribe(data =>this.driver=data);
    }
    else{
      this.invalidMsg = "You must be logged-in first!";
      this.router.navigate(['login']);
    }
    
  }

  viewPastTrips(){
    if(sessionStorage.getItem("userName") != null){
      this.router.navigate(['/past-trips']);
    }
  }

}
