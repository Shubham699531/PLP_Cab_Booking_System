import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TripDetailsComponent } from './trip-details/trip-details.component';
import { CabBookingFormComponent } from './trip-details/cab-booking-form/cab-booking-form.component';
import { EstimatedPriceInfoComponent } from './trip-details/estimated-price-info/estimated-price-info.component';

@NgModule({
  declarations: [
    AppComponent,
    TripDetailsComponent,
    CabBookingFormComponent,
    EstimatedPriceInfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
