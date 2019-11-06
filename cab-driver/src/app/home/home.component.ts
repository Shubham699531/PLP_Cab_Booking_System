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
  email : String ;
  isHidden : boolean =true;

  constructor(private service: DriverService, private router:Router) { 
    this.driver = new CabDriver();
  }

  ngOnInit() {
    this.email = this.service.userName;
    this.service.fetchDriver(this.email).subscribe(data => this.driver=data);
  }

  viewPastTrips(){
    if(this.service.userName != ""){
      this.router.navigate(['/past-trips']);
    }
  }

}
