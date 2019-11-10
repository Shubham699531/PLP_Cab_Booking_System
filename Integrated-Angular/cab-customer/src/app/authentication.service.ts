import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthenticationService {

  constructor() { }

  authenticate(username, password) {
    if (username === "admin" && password === "admin") {
      sessionStorage.setItem("role", "admin")
      alert("Login Successful");
      return true; 
    } else {
      alert("Invalid Credential")
      return false;
    }
    
  }

  isUserLoggedIn() {
    let login = sessionStorage.getItem('username')
    console.log(!(login === null))
    return !(login === null)
  }

 
}