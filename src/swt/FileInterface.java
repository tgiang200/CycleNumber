package swt;

public interface FileInterface {
	boolean checkSize(String path, long size, String type);
	boolean checkExtension(String path, String extension);
	boolean checkContent(String path, String content);
}
