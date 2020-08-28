
public class NonLuxuryMotorcycle implements Motorcycle {

	private String name;

	public NonLuxuryMotorcycle(String cName) {
		name = cName;
	}

	public String getMotorcycleName() {
		return name;
	}

	public String getMotorcycleFeatures() {
		return "Non-Luxury Motorcycle Features ";
	}

}
