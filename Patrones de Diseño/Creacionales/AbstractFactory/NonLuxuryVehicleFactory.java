public class NonLuxuryVehicleFactory extends VehicleFactory {

	public Car getCar() {
		return new NonLuxuryCar("NL-C");
	}

	public SUV getSUV() {
		return new NonLuxurySUV("NL-S");
	}

	public Motorcycle getMorotcycle() {
		return new NonLuxuryMotorcycle("NL-M");
	}
} // End of class
