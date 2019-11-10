import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { AdminComponent } from '../admin/admin.component';
import { CustomerComponent } from '../customer/customer.component';
import { DriverComponent } from '../driver/driver.component';
import { CustSignupComponent } from '../cust-signup/cust-signup.component';
import { DriverSignupComponent } from '../driver-signup/driver-signup.component';

const routes: Routes = [
  {path:'', redirectTo:'/login', pathMatch:'full'},
  {path:'login', component:LoginComponent},
  {path:'admin', component:AdminComponent},
  {path:'customer', component:CustomerComponent},
  
  {path:'driver', component:DriverComponent},
  {path:'cust-signup', component:CustSignupComponent},
  {path:'driver-signup', component:DriverSignupComponent},
  {path:'**', redirectTo:'/login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
