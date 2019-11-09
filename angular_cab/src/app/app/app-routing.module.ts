import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../addDriver/signup.component';
import { ListComponent } from '../listDriver/list.component';
import { CommonModule } from '@angular/common';
import { ReportComponent } from '../customerIssues/report.component';
import { FetchComponent } from '../fetchDriver/fetch.component';
import { SolveComponent } from '../solveIssues/solve.component';
import { HomeComponent } from '../home/home.component';
import { BookingdetailsComponent } from '../bookingdetails/bookingdetails.component';


const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'fetch',component:FetchComponent},
  {path:'signup',component:SignupComponent},
  {path:'bookingdetails',component:BookingdetailsComponent},
  {path:'list',component:ListComponent},
  {path:'report',component:ReportComponent},
  {path:'solve',component:SolveComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}

];

@NgModule({
  imports: [
    CommonModule, RouterModule.forRoot(routes)],
    declarations:[],
  exports: [RouterModule]
})
export class AppRoutingModule { }

