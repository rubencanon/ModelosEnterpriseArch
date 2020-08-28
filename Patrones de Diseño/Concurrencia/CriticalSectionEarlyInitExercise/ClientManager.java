
public class ClientManager {

	public static void main(String[] args) {
		FileProcess proceso1 = new FileProcess("Thread 1 is wrtting");
		proceso1.start();
		FileProcess proceso2 = new FileProcess("Thread 2 is writting");
		proceso2.start();
	}
}

class FileProcess extends Thread {
	private String msgLog;

	public FileProcess(String msg) {
		this.msgLog = msg;
	}

	@Override
	public void run() {
		// Obtener el ejemplar de registrador

			long tr1 = System.nanoTime();

			Logger fileLogger = FileLogger.getFileLogger();
			long tr2 = System.nanoTime();
			long timeDiff = tr2 - tr1;

			System.out.println(msgLog + ", Tiempo getFileLogger," + timeDiff + " nanosegundos");
			long tw1 = System.nanoTime();

			for (int i = 0; i < 20; i++) {
				// Registrar Mensaje
				fileLogger.log(msgLog);
			}//for
			long tw2 = System.nanoTime();
			long timeWDiff = tw2 - tw1;
			System.out.println(msgLog +", Tiempo log," + timeWDiff );

	}

}
