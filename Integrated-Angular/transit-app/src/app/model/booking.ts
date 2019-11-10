export class Booking{
    constructor (public bookingId: number=null,
        public customerId: number=null,
        public driverId: number=null,
        public source: string="",
        public destination: string="",
    //    public vehicleSize: number=null,
        public driverStatus:string="",
    //    public customerStatus:string="",
        public tripStatus:string="",
        public estimatedFare:number=null,
        public estimatedTime:number=null,
        public finalFare:number=null,
        public rating:number=null, 
        public issues:string="", 
        public finalTime:number=null
        ){}
}