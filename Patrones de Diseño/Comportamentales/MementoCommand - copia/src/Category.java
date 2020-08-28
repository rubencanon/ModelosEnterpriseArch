
import java.io.Serializable;
import java.util.*;

public class Category implements Serializable {

	private HashMap items;
	private String desc;

	public Category(String s) {
		desc = s;
		items = new HashMap();
	}

	public String getDesc() {
		return desc;
	}

	public void add(Item i) {
		String iDesc = i.getDesc();
		items.put(iDesc, i);
		System.out.println("Item '" + iDesc + "' has been added to the '" + getDesc() + "' Category ");

	}

	public void delete(Item i) {
		String iDesc = i.getDesc();
		items.remove(iDesc);
		System.out.println("Item '" + iDesc + "' has been deleted from the '" + getDesc() + "' Category ");
	}
}
