package comportamentales.strategy;
public class FileLogger implements Logger {

  private static FileLogger logger;

  //Prevent clients from using the constructor
  private FileLogger() {
  }

  public static synchronized FileLogger getFileLogger() {
    if (logger == null) {
      logger = new FileLogger();
    }
    return logger;
  }

  public synchronized void log(String file,String msg) {
    FileUtil futil = new FileUtil();
    futil.writeToFile(file,msg, true, true);
  }

}
