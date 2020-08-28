package creacionales.abstractFactory;
public class LuxuryVehicleFactory extends VehicleFactory {

	public Car getCar() {
		return new LuxuryCar("L-C");
	}

	public SUV getSUV() {
		return new LuxurySUV("L-S");
	}

	public Motorcycle getMorotcycle() {
		return new LuxuryMotorcycle("L-M");
	}

} // End of class
