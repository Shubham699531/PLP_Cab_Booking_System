import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { TripDetails } from './model/tripdetails.model';
@Injectable({
  providedIn: 'root'
})
export class BookService {
  private messageSource = new Subject<TripDetails>();
  private showMessage = new Subject<boolean>();

  tripdetails$ = this.messageSource.asObservable();
  showMessage$ = this.showMessage.asObservable();

  locations:string[] =[];
  price:number;
  constructor(public http:HttpClient ) { }

  getLocations(){
    return this.http.get<string[]>("http://localhost:8001/tripdetails/allLocations");
  }

  getEstimetePrice(details :TripDetails):Observable<number>{
    return this.http.post<number>("http://localhost:8001/tripdetails/estimateprice",details);
  }

  saveBooking(details : TripDetails){
    return this.http.post<TripDetails>("http://localhost:8001/tripdetails/add", details);
  }

  sendTripDetails(details : TripDetails){
    this.messageSource.next(details);
  }

  sendShowMessage(message : boolean){
    this.showMessage.next(message);
  }

}
