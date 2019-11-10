import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { CustSignupComponent } from '../cust-signup/cust-signup.component';
import { DriverSignupComponent } from '../driver-signup/driver-signup.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
  {path:"", component:LoginComponent},
   {path:"cust-signup", component:CustSignupComponent},
  {path:"driver-signup", component:DriverSignupComponent},
  {path:"**", component:LoginComponent}
];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class CabRoutingModule { }
