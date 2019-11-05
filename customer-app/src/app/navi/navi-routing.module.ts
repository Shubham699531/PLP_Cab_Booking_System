import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { HistoryComponent } from '../history/history.component';
import { BookingComponent } from '../booking/booking.component';
import { CommonModule } from '@angular/common';
import { CustomerHomeComponent } from '../customer-home/customer-home.component';
import { FindTripComponent } from '../find-trip/find-trip.component';

const routes: Routes = [
 // {path: '', redirectTo:'login', pathMatch:'full'},
  {path: 'login',component:LoginComponent},
  {path: 'history', component:HistoryComponent},
  {path: 'booking',component:BookingComponent},
  {path: 'find_trip', component:FindTripComponent},
  {path: 'customer_home', component:CustomerHomeComponent},
 // {path: '**', redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NaviRoutingModule { }
