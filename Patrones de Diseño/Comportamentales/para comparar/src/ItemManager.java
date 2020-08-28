

import java.util.*;

public class ItemManager {
  CommandInterface command;

  public void setCommand(CommandInterface c) {
    command = c;
  }

  public boolean process() {
   return command.execute();
  }
}
