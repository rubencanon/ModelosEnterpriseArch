

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MementoHandler {

	private CommandProcesor.Memento objMemento = null;
	public static final String ID_FILE = "ComandosMemento.txt";

	public CommandProcesor.Memento getMemento() {
		ObjectInputStream objStream = null;
		FileUtil util = new FileUtil();

		if (util.isFileExists(ID_FILE)) {
			// read the object from the file
			try {
				objStream = new ObjectInputStream(new FileInputStream(new File(ID_FILE)));

				objMemento = (CommandProcesor.Memento) objStream.readObject();
				objStream.close();

			} catch (Exception e) {
				System.out.println("Error Reading Memento");
				System.exit(1);
			}
			// delete the old memento
			util.deleteFile(ID_FILE);
		} 
		return objMemento;
	}
	public void setMemento(CommandProcesor.Memento memento) {
		ObjectOutputStream objStream = null;

		// write the object to the file
		try {
			objStream = new ObjectOutputStream(new FileOutputStream(new File(ID_FILE)));

			objStream.writeObject(memento);
			objStream.close();

		} catch (Exception e) {
			System.out.println("Error Writing Memento");
			System.exit(1);
		}
	}
}
