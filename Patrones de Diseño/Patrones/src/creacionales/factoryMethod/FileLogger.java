package creacionales.factoryMethod;

public class FileLogger implements Logger {

  public void log(String msg) {
    FileUtil futil = new FileUtil();
    futil.writeToFile("src\\creacionales\\factoryMethod\\log.txt",msg, true, true);
  }

}
