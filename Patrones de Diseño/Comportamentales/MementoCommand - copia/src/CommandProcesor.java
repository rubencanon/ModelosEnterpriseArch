import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Iterator;

public class CommandProcesor implements Serializable {
	public static final String DATA_FILE = "InputCommands.txt";

	private Vector<CommandInterface> commandList;

	
	public CommandProcesor() {
		super();
		commandList = new Vector<CommandInterface>();
	}

	class Memento implements Serializable {
		private Vector<CommandInterface> commandList;

		public List<CommandInterface> getCommand() {
			return commandList;
		}

		public void setCommand(Vector<CommandInterface> commandLst) {
			this.commandList = commandLst;
		}

		public Memento(Vector<CommandInterface> commandLst) {
			this.commandList = commandLst;
		}

	}

	public List<CommandInterface> getCommandList() {
		return commandList;
	}


	public void setMemento(Memento memento) {
		if (memento != null)
			commandList = memento.commandList;
	}

	public Memento createMemento() {
		return (new Memento(commandList));
	}

	public void getCommandsFromFile() {

		String inputLine = "";

		try {
			File inFile = new File(DATA_FILE);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));

			while ((inputLine = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(inputLine, ",");
				String commandId = st.nextToken();
				String itemName = st.nextToken();
				String categoryName = st.nextToken();

				Category category = new Category(categoryName);
				Item item = new Item(itemName);
				CommandInterface command;
				if (commandId.equalsIgnoreCase("0")) {
					
					command = new DeleteCommand(item, category);
					commandList.add(command);

				} else if (commandId.equalsIgnoreCase("1")) {
					command = new AddCommand(item, category);
					commandList.add(command);

				} else {
					System.out.println("Comando no reconocido, no ser� tenido en cuanta");
				}

			}
			br.close();
		} // Try
		catch (Exception ex) {
			System.out.println(" An error has occurred in line " + inputLine + "-" + ex.getMessage());
			System.exit(1);
		}

	}

	public boolean processCommands() {
		boolean success = true;

		ItemManager manager = new ItemManager();

		// recorre y ejecuta la lista de comandos

		Iterator i = commandList.iterator();

		while (i.hasNext()) {
			CommandInterface command = (CommandInterface) i.next();
			manager.setCommand(command);
			if (!manager.process()) {
				success = false;
				break;
			} else {
				i.remove();
			}
		}

		return success;

	}

}
