import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 

  username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,
    private service: AuthenticationService) { }

 
  
  ngOnInit() {
  }

  checkLogin() {
    if (this.service.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['home'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

}