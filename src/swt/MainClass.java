package swt;

public class MainClass {
	public static void main(String [] args){
		FileInterface file = new FileTxt();
		System.out.println(file.checkExtension("D://test.txt", "txt"));
	}
}
