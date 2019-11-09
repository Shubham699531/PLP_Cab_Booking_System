import { Component, OnInit } from '@angular/core';
import { DriverService } from '../service/driver.service';
import { Driver } from '../model/driver.model';
import { Router } from '@angular/router';



@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  driver: Driver;
  driverId:number;
  drivers:Driver[];
  
    constructor(private service:DriverService, private route:Router) {
    this.driver= new Driver();
   }


  ngOnInit() {
  
    this.service.listDriver().subscribe(data => this.drivers =data);
   
      
  }
  deleteDriver(driver: Driver): void {
    var ans = confirm("Are you sure you want to delete?")
    if(ans){
    this.service.deleteDriver(driver.driverId)
      .subscribe(data => {
        this.drivers = this.drivers.filter(d => d !== driver);
        
      })}
  };
  
  
     verifyDriver(driver: Driver){  
       this.service.set(driver)    
           this.route.navigate(['signup']);            
     }
     home(){
      this.route.navigate(['home']);
     }
     addDriver(){  
       let driver= new Driver();
      this.service.set(driver)    
          this.route.navigate(['signup']);            
    }
    logOut(){
      this.route.navigate(['login']);
    }
   
}
