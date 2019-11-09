import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-solve',
  templateUrl: './solve.component.html',
  styleUrls: ['./solve.component.css']
})
export class SolveComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }
  home(){
    this.route.navigate(['home']);
   }
   logOut(){
    this.route.navigate(['login']);
  }
}
