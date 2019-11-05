import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegcustomerComponent } from '../regcustomer/regcustomer.component';
import { LoginComponent } from '../login/login.component';
import { RegdriverComponent } from '../regdriver/regdriver.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'regcustomer',component:RegcustomerComponent},
  {path:'regdriver',component:RegdriverComponent},
  {path:'**',redirectTo:'/login',pathMatch:'full'}];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  declarations:[],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
