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

   ngOnInit() {
    
   }

  verifyLogin(){
    
    //LOGIN AS DRIVER LOGIC GOES HERE
      this.service.verifyLogin(this.user).subscribe(data=>{this.driver=data;
        if(this.driver.driverId > 0){
          sessionStorage.setItem("userName",this.driver.email);
          sessionStorage.setItem("role",this.user.role);
          sessionStorage.setItem("driverId",this.driver.driverId.toString());
          this.invalidMsg = '';
          this.router.navigate(['home']);
        }
        else{
          sessionStorage.removeItem("userName");
          sessionStorage.removeItem("driverId");
          sessionStorage.removeItem("role");
          alert("Invalid Credentials !");
        }
    });
   
  }
    signup(){
      this.router.navigate(['register']);
    }
      

}
