public class LoggerTest {
  public static void main(String[] args) {
    LoggerFactory factory = new LoggerFactory();
    Logger logger = factory.getLogger();
    logger.log("Write the message to selected output");
  }
}
