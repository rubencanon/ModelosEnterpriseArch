package after;


public class FileSystemManager {

	public static void main(String[] args) {
		// Creaci�n Directorio1
		Directory objDir1 = new Directory("Directory1");
		Directory objDir2 = new Directory("Directory2");

		FileSysUtil_Rev fsUtil = new FileSysUtil_Rev();

		DirectoryProcess threadA = new DirectoryProcess(objDir1, objDir2, fsUtil);
		threadA.start();
		DirectoryProcess threadB = new DirectoryProcess(objDir2,objDir1, fsUtil );
		threadB.start();
	}
}

class DirectoryProcess extends Thread {
	Directory sourceDir;
	Directory destinationDir;
	FileSysUtil_Rev fsUtil;

	public DirectoryProcess(Directory sourceDir, Directory destinationDir, FileSysUtil_Rev fsUtil) {
		this.sourceDir = sourceDir;
		this.destinationDir = destinationDir;
		this.fsUtil = fsUtil;
	}

	@Override
	public void run() {


		//System.out.println("Moving: "  +sourceDir + " to "+ destinationDir);
		fsUtil.moveContents(sourceDir, destinationDir);
	}
}
