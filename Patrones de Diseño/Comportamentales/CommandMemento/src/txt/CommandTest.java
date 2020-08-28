package txt;

import java.util.*;

public class CommandTest {

  public static void main(String[] args) {

    //Add an item to the CD category
    //create Receiver objects
    Item CD = new Item("A Beautiful Mind");
    Category catCD = new Category("CD");
    //create the command object
    CommandInterface command = new AddCommand(CD, catCD);
    //create the invoker
    ItemManager manager = new ItemManager();
    //configure the invoker
    //with the command object
    manager.setCommand(command);
    manager.process();
   
    catCD = new Category("CD");

    //Add an item to the CD category
    CD = new Item("Duet");
    command = new AddCommand(CD, catCD);
    manager.setCommand(command);
    manager.process();
  
    CD = new Item("Duet1");
    command = new AddCommand(CD, catCD);
    manager.setCommand(command);
    manager.process();
    
    CD = new Item("Duet2");
    command = new AddCommand(CD, catCD);
    manager.setCommand(command);
    manager.process();  
    
    
    //Delete an item from the New Releases category
    command = new DeleteCommand(CD, catCD);
    manager.setCommand(command);
    manager.process();

  }
}
