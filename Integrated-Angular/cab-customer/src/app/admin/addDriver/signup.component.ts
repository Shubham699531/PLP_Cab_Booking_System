import { Component, OnInit } from '@angular/core';
import { Driver } from '../model/driver.model';
import { DriverService } from '../service/driver.service';
import { Router } from '@angular/router';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  datepickerConfig: Partial<BsDatepickerConfig>;
  driver: Driver;

  id:number;
  
  public driverStatus:string[]=['Verified','Not Verified'];

  constructor(private service:DriverService, private route:Router) { 
    
    this.driver= new Driver();
    this.datepickerConfig= Object.assign({},
    {containerClass:'theme-dark-blue',
  minDate: new Date(2018, 0,1),
  maxDate: new Date(2018, 11, 31),
  });

   
  }

    
  
  ngOnInit() {
   this.driver= this.service.get();
  //this.drivers= new Driver();
    }
    
  
  onUpdate(){
  
    var ans = confirm("Are you sure to update the status")
    if(ans){
    this.service.updateDriver(this.driver).subscribe( data => {
      this.route.navigate(['list']);
    })}};


    home(){
      this.route.navigate(['home']);
     }

     
}
