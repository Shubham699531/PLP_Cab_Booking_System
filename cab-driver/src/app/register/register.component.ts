import { Component, OnInit } from '@angular/core';
import { DriverService } from '../driver.service';
import { CabDriver } from '../model/driver_model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  driver: CabDriver;

  constructor(private service: DriverService, private router : Router) { 
  }

  ngOnInit() {
    this.driver = new CabDriver();
  }

  addNewDriver(){
    this.service.addNewDriver(this.driver).subscribe();
    this.driver = new CabDriver();
    this.router.navigate(['/home']);
  }

}
