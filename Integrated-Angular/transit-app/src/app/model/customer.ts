export class Customer{
    constructor (public customerId: number=null,
        public name:string="",
        public password:string="",
        public dob:Date=null,
        public gender:string="",
        public contactNo:string="",
        public email:string="",
        public address:string="",
        public wallet:number=0
        ){}
}