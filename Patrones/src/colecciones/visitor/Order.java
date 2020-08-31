package colecciones.visitor;
public interface Order {
  public void accept(OrderVisitor v);
}
