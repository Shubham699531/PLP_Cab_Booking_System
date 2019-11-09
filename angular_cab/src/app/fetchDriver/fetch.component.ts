import { Component, OnInit } from '@angular/core';
import { DriverService } from '../service/driver.service';
import { Report } from '../model/report.model';
import { Driver } from '../model/driver.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fetch',
  templateUrl: './fetch.component.html',
  styleUrls: ['./fetch.component.css']
})
export class FetchComponent implements OnInit {
  report : Report;
  driver: Driver;
  id: number;
  flag:boolean=false;
 
  
  constructor(private service:DriverService, private route:Router) { 
  
    this.driver= new Driver();
  }

  ngOnInit() {
    this.report= this.service.getter();
    
   //this.driver= new Driver();
  }

  searchDriver(){
    this.service.findDriver(this.id).subscribe(data => this.driver =data);
    if(this.driver != null)
    this.flag= true;
    else
    alert("Driver not found");
      


    
 }
 issueResolved(){
  this.route.navigate(['solve']);
 }
 home(){
  this.route.navigate(['home']);
 }

 logOut(){
  this.route.navigate(['login']);
}
}
