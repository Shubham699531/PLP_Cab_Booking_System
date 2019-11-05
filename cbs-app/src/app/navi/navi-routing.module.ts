import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegcustomerComponent } from '../regcustomer/regcustomer.component';
import { LoginComponent } from '../login/login.component';
import { RegdriverComponent } from '../regdriver/regdriver.component';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from '../customer/customer.component';
import { HomeComponent } from '../home/home.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {path:'customer',component:CustomerComponent},
  {path:'regcustomer',component:RegcustomerComponent},
  {path:'regdriver',component:RegdriverComponent},
  {path:'**',redirectTo:'/home',pathMatch:'full'}];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  declarations:[],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
