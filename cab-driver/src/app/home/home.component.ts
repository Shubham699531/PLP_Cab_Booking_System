import { Component, OnInit } from '@angular/core';
import { CabDriver } from '../model/driver_model';
import { DriverService } from '../driver.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  driver: CabDriver;
  email : String ;
  isHidden : boolean =true;

  constructor(private service: DriverService) { 
    this.driver = new CabDriver();
  }

  ngOnInit() {
  }

  fetchDriver(){
    this.service.fetchDriver(this.email).subscribe(data => this.driver=data);
    if(this.driver.name != ""){
      this.isHidden=false;
    }
  }

}
