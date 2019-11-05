import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { CabDriver } from '../model/driver_model';
import { DriverService } from '../driver.service';
import { Router } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
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
     this.service.verifyLogin(this.user).subscribe(data =>this.driver = data);

    if(this.driver.driverId > 0){
      console.log("login successfull");
      this.invalidMsg = '';
      this.router.navigate(['home']);
    }
    else{
      this.router.navigate(['register']);
      console.log("INVALID CREDENTIALS!");
      this.invalidMsg = "INVALID CREDENTIALS!";
    }
  }

}
