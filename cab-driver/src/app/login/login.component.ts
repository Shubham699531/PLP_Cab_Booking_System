import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { CabDriver } from '../model/driver_model';
import { DriverService } from '../driver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user : User;
  driver : CabDriver;
  invalidMsg : String;

  constructor(private service: DriverService, private router:Router) { 
    this.user = new User();
    this.driver = new CabDriver();
  }

  // ngOnInit() {
    
  // }

  verifyLogin(){
    // if(this.service.userName != ""){
    //   this.user.email = this.service.userName;
    // }
    //if(this.user.role == "driver"){
     this.service.verifyLogin(this.user).subscribe(data=>this.driver=data);
     //console.log(this.driver.driverId);
     //console.log(this.driver.password);

    if(this.driver.driverId > 0){
      //console.log("login successfull");
      this.service.userName = this.user.email;
      this.invalidMsg = '';
      this.router.navigate(['home']);
    }
    else{
      this.invalidMsg = "Invalid Credentials!";
    }
  //}
  }
    signup(){
      this.router.navigate(['register']);
    }
      

}
