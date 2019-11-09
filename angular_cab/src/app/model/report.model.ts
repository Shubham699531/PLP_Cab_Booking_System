export class Report{
   
   constructor (public reportId:number=null, 
  public bookingId: number=0,
  public driverId: number=0,
  public customerId: number=0,
  public issues: string= "",
  ){}
}
