import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { CommonModule } from '@angular/common';
import { HomeComponent } from '../home/home.component';
import { LoginComponent } from '../login/login.component';
import { PastTripsComponent } from '../past-trips/past-trips.component';
import { LogoutComponent } from '../logout/logout.component';
import { AboutComponent } from '../about/about.component';


const routes: Routes = [
  {path:"register", component:RegisterComponent},
  {path:"home", component:HomeComponent},
  {path:"login", component:LoginComponent},
  {path:"past-trips", component:PastTripsComponent},
  {path:"logout", component:LogoutComponent},
  {path:"about", component:AboutComponent},
  {path: "", redirectTo:"/login", pathMatch:"full"},
  {path:"**", redirectTo:"/login", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule]
})
export class DriverRoutingModule { }
