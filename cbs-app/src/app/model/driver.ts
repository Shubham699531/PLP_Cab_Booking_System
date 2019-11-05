export class Driver{
    constructor(
        public name : String = "",
        public dob : Date = null,
        public gender : String = "Male",
        public contactNo : String = "",
        public email : String = "",
        public address : String = "",
        public vehicleNo : String = "",
        public password : String = "",
        public vehicleType : String = "",
        public noOfTrips : number = 0,
        public driverStatus : String = null
        ){}
    }