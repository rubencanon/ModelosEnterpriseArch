package concurrencia.guardedSuspension;
public class WorkshopSimulator {
	public static void main(String[] args) {
		Workshop workshop = new Workshop();
		new Vehicle("Veh�culo1", workshop);
		new Vehicle("Veh�culo2", workshop);
		new Vehicle("Veh�culo3", workshop);
		new Vehicle("Veh�culo4", workshop);
		new Vehicle("Veh�culo5", workshop);
		new Vehicle("Veh�culo6", workshop);
		new Vehicle("Veh�culo7", workshop);
		new Vehicle("Veh�culo8", workshop);

	}

}

class Workshop {
	// Assume 4 parking slots for simplicity
	public static final int MAX_CAPACITY = 5; // Cupo M�ximo del Taller
	private int inspectingCarsTotal = 0; // Numero Total de Veh�culos en Revisi�n

	public synchronized void inspect(String vehicle) {
		while (inspectingCarsTotal >= MAX_CAPACITY) {
			try {
				System.out.println(" El taller est� lleno el " + vehicle + " debe esperar ");
				wait();
			} catch (InterruptedException e) {
				//
			}
		}
		// precondition is true
		System.out.println(vehicle + " entr� a revisi�n");
		inspectingCarsTotal = inspectingCarsTotal + 1;
	}

	public synchronized void leave(String vehicle) {
		inspectingCarsTotal = inspectingCarsTotal - 1;
		System.out.println(vehicle + " se ha ido, realizar notificaci�n a vehiculo en espera");
		notify();
	}
}

class Vehicle extends Thread {
	private Workshop workshop;
	private String name;

	Vehicle(String n, Workshop w) {
		name = n;
		workshop = w;
		start();
	}

	public void run() {
		System.out.println(name + " est� listo para revisi�n");
		workshop.inspect(name);
		try {
			sleep(800); // tiempo de inspeccion simulada 800ms
		} catch (InterruptedException e) {
			//
		}
		workshop.leave(name);
	}
}
