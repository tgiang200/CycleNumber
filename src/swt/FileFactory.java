package swt;

public class FileFactory {
	public FileInterface getTypeOfFile(String typeOfFile){
		if (typeOfFile.equalsIgnoreCase("txt")){
			return new FileTxt();
		}
		return null;
	}
}
