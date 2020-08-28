import java.io.Serializable;
import java.util.Random;

public class AddCommand implements CommandInterface, Serializable {

	public static final String OUTPUT_FILE = "ComandosProcesados.txt";

	Item item;
	Category cat;

	public AddCommand(Item i, Category c) {
		item = i;
		cat = c;
	}

	public boolean execute() {
		boolean success = false;
		FileUtil util = new FileUtil();
		String outPut;
		if (util.simulateError() == false) {
			item.add(cat);
			cat.add(item);
			outPut = "Proceso AddCommand ha insertado el elemento: " + item.getDesc() + " en la categor�a: "+ cat.getDesc();
			success = true;
		} else {
			outPut = "Proceso AddCommand genero un error: El elemento: " + item.getDesc()
					+ " No se insert� en la categor�a: " + cat.getDesc();
		}
		util.writeToFile(OUTPUT_FILE, outPut, true, true);

		return success;
	}

}
