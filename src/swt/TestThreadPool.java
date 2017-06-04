package swt;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
	
	private String root;
	
	public TestThreadPool(String path){
		this.root=path;
	}
	
	
	
	public void getPath(){
		ExecutorService executor = Executors.newFixedThreadPool(1);
		File folder = new File(this.root);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				WorkDirectory w = new WorkDirectory(this.root);
				executor.execute(w);
			} else if (listOfFiles[i].isDirectory()) {
				TestThreadPool ttp =  new TestThreadPool(root + "/" + listOfFiles[i].getName());
				ttp.getPath();
			}
		}
	
		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}
	
	public static void main(String [] args){
		TestThreadPool t = new TestThreadPool("D:/directory");
		t.getPath();
		System.out.println(new WorkDirectory("D:/directory").getListPath());
	}
}
