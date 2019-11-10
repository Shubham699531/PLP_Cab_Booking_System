import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TransitDriverComponent } from '../transit-driver/transit-driver.component';

import { TransitUserComponent } from '../transit-user/transit-user.component';
import { AddPaymentComponent } from '../add-payment/add-payment.component';
import { AddReportComponent } from '../add-report/add-report.component';
import { TripEndedComponent } from '../trip-ended/trip-ended.component';

const routes: Routes = [
  { path: '', redirectTo: '/transit', pathMatch: 'full' },
  { path: 'transit', component: TransitDriverComponent },
  { path: 'user', component: TransitUserComponent },

  {path:"add-payment", component: AddPaymentComponent},
  {path:"add-report", component:  AddReportComponent},
  {path:"tripEnded", component: TripEndedComponent},
  { path: '**', redirectTo: '/transit', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class NavRoutingModule { }
