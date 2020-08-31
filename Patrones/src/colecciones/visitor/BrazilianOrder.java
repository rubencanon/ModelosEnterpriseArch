package colecciones.visitor;
public class BrazilianOrder implements Order {
  private double orderAmount;
  private double additionalSH;

  public BrazilianOrder() {
  }
  public BrazilianOrder(double inp_orderAmount,  double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
}
