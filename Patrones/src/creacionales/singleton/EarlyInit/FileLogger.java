package creacionales.singleton.EarlyInit;
public class FileLogger implements Logger {

  private static FileLogger logger = new FileLogger();

  //Prevent clients from using the constructor
  private FileLogger() {
	
  }

  public static FileLogger getFileLogger() {
    return logger;
  }

  public synchronized void log(String msg) {
    FileUtil futil = new FileUtil();
    futil.writeToFile("log.txt",msg, true, true);
  }

}
