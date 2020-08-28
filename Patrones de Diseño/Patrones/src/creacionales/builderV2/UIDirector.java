package creacionales.builderV2;
public class UIDirector {
  private UIBuilder builder;

  public UIDirector(UIBuilder bldr) {
    builder = bldr;
  }
  public void build() {
    builder.addUIControls();
    builder.initialize();
  }

}

