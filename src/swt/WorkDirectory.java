package swt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WorkDirectory implements Runnable{
	
	private String directory;
	
	private static List<String> listPath = new ArrayList<String>();
	
	public WorkDirectory(String root){
		this.directory=root;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" Start");
		File folder = new File(this.directory);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				this.listPath.add(listOfFiles[i].getName());
			}
		}
		System.out.println(Thread.currentThread().getName()+"Start");
	}
	
	public List<String> getListPath(){
		return this.listPath;
	}
}
