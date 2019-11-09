import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username, password) {
    if (username === "admin" && password === "admin") {
      sessionStorage.setItem('username', username)
      alert("Login Successful");
      return true; 
    } else {
      alert("Invalid Credential please write the correct credentials")
      return false;
    }
    
  }

  isUserLoggedIn() {
    let login = sessionStorage.getItem('username')
    console.log(!(login === null))
    return !(login === null)
  }

 
}