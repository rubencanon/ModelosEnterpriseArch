package colecciones.visitorRefactored;
import java.util.*;

class BarCodeVisitor implements VisitorInterface {
	private Vector orderObjList;
	private String barCode;

	public BarCodeVisitor() {
		orderObjList = new Vector();
	}

	public void visit(NonCaliforniaOrder inp_order) {
		barCode = "Barcode: NonCaliforniaOrder";
		System.out.println(barCode);
	}

	public void visit(CaliforniaOrder inp_order) {
		barCode = "Barcode: CaliforniaOrder";

		System.out.println(barCode);
	}

	public void visit(OverseasOrder inp_order) {
		barCode = "Barcode: OverseasOrder";

		System.out.println(barCode);
	}

	// new visitor for brazialianOrder
	public void visit(BrazilianOrder inp_order) {
		barCode = "Barcode: BrazilianOrder";

		System.out.println(barCode);
	}

	public String getBarCode() {
		return barCode;
	}

	public void addOrder(Order order) {
		orderObjList.add(order);
	}

	public Vector getOrderObjList() {
		return orderObjList;
	}

}
