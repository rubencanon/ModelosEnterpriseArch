package colecciones.visitorRefactored;
public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
  public void visit(BrazilianOrder bo); // new visit method for BrazilianOrder

}
