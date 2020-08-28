
public class LuxuryMotorcycle implements Motorcycle {

	private String name;

	public LuxuryMotorcycle(String cName) {
		name = cName;
	}

	public String getMotorcycleName() {
		return name;
	}

	public String getMotorcycleFeatures() {
		return "Luxury Motorcycle Features ";
	}

}
