import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { CommonModule } from '@angular/common';
import { CustomerHomeComponent } from '../customer-home/customer-home.component';
import { TransitDriverComponent } from '../transit-driver/transit-driver.component';
import { TransitUserComponent } from '../transit-user/transit-user.component';
import { AddPaymentComponent } from '../add-payment/add-payment.component';
import { AddReportComponent } from '../add-report/add-report.component';
import { TripEndedComponent } from '../trip-ended/trip-ended.component';

const routes: Routes = [
  {path:'', redirectTo:'cust-login', pathMatch:'full'},
  {path:'customerhome', component:CustomerHomeComponent},
  {path:'cust-login', component:LoginComponent},
  { path:'transit', component: TransitDriverComponent },
  { path:'user', component: TransitUserComponent },
  {path:"add-payment", component: AddPaymentComponent},
  {path:"add-report", component:  AddReportComponent},
  {path:"tripEnded", component: TripEndedComponent},
  {path: '**', redirectTo:'cust-login',pathMatch:'full'}
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
