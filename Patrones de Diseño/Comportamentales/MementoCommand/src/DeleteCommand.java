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
		String outPut;
		if (util.simulateError() == false) {
			item.delete(cat);
			cat.delete(item);
			outPut = "Proceso DeleteCommand el elemento: " + item.getDesc() + " Se eliminó de la categoría: "
					+ cat.getDesc();
			success = true;
		} else {
			outPut = "Proceso DeleteCommand genero un error- El elemento: " + item.getDesc()	+ " No se eliminó de la categoría: " + cat.getDesc();

		}
		util.writeToFile(OUTPUT_FILE, outPut, true, true);

		return success;
	}

}
