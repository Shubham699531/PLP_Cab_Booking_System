export class Driver {
    constructor(public driverId: number = null,
        public name: string = "",
        public dob: Date = null,
        public gender: string = "",
        public contactNo: string = "",
        public email: string="",
        public password: string="",
        public address: string = null,
        public vehicleNo: string = null,
        public drivingLicense: string="",
        public driverStatus: string="",
        public rating: number = null,
        public numberOfTrips: number = null) { }
}