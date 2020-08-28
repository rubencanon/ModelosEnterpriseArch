import java.io.Serializable;

public class DeleteCommand implements CommandInterface, Serializable {
	Item item;
	Category cat;
	public static final String OUTPUT_FILE = "ComandosProcesados.txt";

	public DeleteCommand(Item i, Category c) {
		item = i;
		cat = c;
	}

	public boolean execute() {
		boolean success = false;
		FileUtil util = new FileUtil();

		if (util.simulateError() == false) {
			item.delete(cat);
			cat.delete(item);
			String outPut = "Proceso DeleteCommand el elemento: " + item.getDesc() + " Se elimin� de la categor�a: "
					+ cat.getDesc();
			util.writeToFile(OUTPUT_FILE, outPut, true, true);
			success = true;
		} else {
			String outPut = "Proceso DeleteCommand genero un error- El elemento: " + item.getDesc()
					+ " No se elimin� de la categor�a: " + cat.getDesc();
			util.writeToFile(OUTPUT_FILE, outPut, true, true);

		}

		return success;
	}

}
