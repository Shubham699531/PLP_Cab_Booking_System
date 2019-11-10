import { Component, OnInit, DoCheck, AfterContentChecked, AfterContentInit, AfterViewChecked } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'cbs-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isAdmin: boolean = false;
  isAdminLogin: boolean = false;
  isCustomer : boolean = true;
  isCustomerLogin : boolean =false;

  constructor(private route: Router) { }

  ngOnInit() {
  }

  onAdmin() {
    this.isAdmin = true;
    this.route.navigate(['login']);
  }

  redirectHome() {
    this.route.navigate(['adminlogin']);
  }

  redirectAdminList() {
    this.route.navigate(['adminlist']);
  }

  redirectAdminReport() {
    this.route.navigate(['adminreport'])

  }

  redirectAdminBokkingdetails() {
    this.route.navigate(['adminbookingdetails']);
  }

  redirectCustomer() {
    this.route.navigate(['login']);
    this.isAdmin = false;
  }

  customerLogout(){
    alert("logout succesful!");
    sessionStorage.setItem("isCustomerLogin","false");
    this.route.navigate(['login']);
  }

  adminLogout(){
    alert("logout succesful!");
    sessionStorage.setItem("isAdminLogin","false");
    this.route.navigate(['adminlogin']);
  }
}
