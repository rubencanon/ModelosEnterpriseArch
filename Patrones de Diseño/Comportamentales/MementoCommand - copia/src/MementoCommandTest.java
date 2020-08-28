import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

public class MementoCommandTest {

	public static void main(String[] args) {
		MementoHandler objMementoHandler = new MementoHandler();
		CommandProcesor commandProcessor = new CommandProcesor(); /// Originator

		/// Recupera de DD el estado del objeto Originator
		CommandProcesor.Memento memento = objMementoHandler.getMemento();
		if (memento == null) {
			commandProcessor.getCommandsFromFile();
		} else {
			commandProcessor.setMemento(memento);
		}

		if (!commandProcessor.processCommands()) {
			/// Guarda el estado del objeto originator
			System.out.println("El proceso generó un error, Se guardará el estado. Intente de nuevo");
			objMementoHandler.saveMemento(commandProcessor.createMemento());
		} else {
			System.out.println("El proceso finalizó Correctamente");

		}

	}

}
