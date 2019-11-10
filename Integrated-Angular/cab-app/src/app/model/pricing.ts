export class Pricing {
    constructor(public categoryId: number = null,
        public modelType: string = "",
        public basePrice: number = null,
        public ratePerKM: number = null,
        public waitingChargePerMin: number = null) { }
}
