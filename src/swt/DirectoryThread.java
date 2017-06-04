package swt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryThread extends Thread {
	private static List<String> listPath = new ArrayList<String>();
	private String rootPath;

	public DirectoryThread(String rootPath) {
		this.rootPath = rootPath;
	}

	public void getListFile(String directory) {
		File folder = new File(directory);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// System.out.println("File " + listOfFiles[i].getName());
				listPath.add(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				// System.out.println("Directory " + listOfFiles[i].getName());
				DirectoryThread dt = new DirectoryThread(directory + "/" + listOfFiles[i].getName());
				dt.start();
			}
		}
	}

	public void run() {
		// System.out.println(this.rootPath);
		getListFile(this.rootPath);
		// System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		DirectoryThread d = new DirectoryThread("D://directory");
		d.getListFile("D://directory");
		// d.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(d.getListPath());
	}

	public static List<String> getListPath() {
		return listPath;
	}

	public static void setListPath(List<String> path) {
		DirectoryThread.listPath = path;
	}

}
