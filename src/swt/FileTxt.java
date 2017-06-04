package swt;

public class FileTxt implements FileInterface{

	@Override
	public boolean checkSize(String path, long size, String type) {
		long sizeFile = new FileClass().getSize(path, type);
		if (sizeFile<size){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkExtension(String path, String extension) {
		String extensionFile = new FileClass().getExtension(path);
		if (extension.equalsIgnoreCase(extensionFile)){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkContent(String path, String content) {
		return new FileClass().checkContent(path, content);
	}

}
