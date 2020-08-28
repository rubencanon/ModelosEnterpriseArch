import java.io.*;
import java.util.*;


class Estudiante implements Cloneable {
  //Lower-level object
  private Asignatura clase;

  private String name;
  public Asignatura getAsignatura() {
    return clase;
  }
  public String getName() {
    return name;
  }
  public void setName(String s) {
    name = s;
  }
  public Estudiante(String s, String t) {
    name = s;
    clase = new Asignatura(t);
  }
  public Object clone() {
    //Deep copy
    Estudiante e = new Estudiante(name, clase.getName());
    return e;
  }
}
class Asignatura {

  private String name;

  public String getName() {
    return name;
  }
  public void setName(String s) {
    name = s;
  }
  public Asignatura(String s) {
    name = s;
  }
}
public class DeepCopyTest {

  public static void main(String[] args) {
    //Original Object
    Estudiante e1 = new Estudiante("Pablo Dimaraes","Patrones y Arquitectura");
    System.out.println("Original (orginal values): " +
                       e1.getName() + " - " + 
                       e1.getAsignatura().getName());

    //Clone as a shallow copy
    Estudiante e2 = (Estudiante) e1.clone();

    System.out.println("Clone (before change): " +
                       e2.getName() + " - " + 
                       e2.getAsignatura().getName());

    //change the primitive member
    e2.setName("Liliana Montes");

    //change the lower-level object
    e2.getAsignatura().setName("Ingeniería de Software II");

    System.out.println("Clone (after change): " +
                       e2.getName() + " - " + 
                       e2.getAsignatura().getName());

    System.out.println(
      "Original (after clone is modified): " +
      e1.getName() + " - " + e1.getAsignatura().getName());

  }
}
