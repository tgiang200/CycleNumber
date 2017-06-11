package swt;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckFile {
	public String getContent(String path) {
		StringBuilder contentFile = new StringBuilder();
		FileInputStream in = null;

		try {
			in = new FileInputStream(path);
			int c;
			while ((c = in.read()) != -1) {
				contentFile.append((char) c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new String(contentFile);
	}

	public String getExtension(String path) {
		return "txt";
	}

	public long getSize(String path) {
		return 1000;
	}

	public boolean checkContent(String path, String strSearch) {
		if (strSearch.equals("")) {
			return true;
		}
		if (getContent(path).contains(strSearch)) {
			return true;
		}
		return false;
	}

	public String getLineContent(String path, String strSearch) {
		int line = 0;
		StringBuilder contentLine = new StringBuilder();
		if (checkContent(path, strSearch)) {
			Scanner sc = new Scanner(getContent(path));
			while (sc.hasNext()) {
				contentLine = new StringBuilder(sc.nextLine());
				line++;
				if (contentLine.toString().contains(strSearch)) {
					return line + " - " + sc.nextLine();
				}
			}
		}
		return "";
	}

	public boolean checkExtension(String path, String extension) {
		String extensionFile = getExtension(path);
		if (extension.equals("")) {
			return true;
		}
		String []arrExtension = extension.split(",");
		for (int i=0; i<arrExtension.length; i++){
			String ex = arrExtension[i].trim();
			if (ex.equals(extensionFile)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkSize(String path, String strSize, String sizeType) {
		if (strSize.equals("")) {
			return true;
		}
		try {
			long size = Long.parseLong(strSize);
			if (getSize(path) < size) {
				return true;
			}
		} catch (Exception e) {

		}

		return false;
	}

	public static void main(String[] args) {
		String param[] = {"D:/test.txt", "exe, txt", "10000", "kb", "A1"};
		//String arr[] = str.split(",");
		boolean sline = (new CheckFile()).validateFile(param);
		String line = new CheckFile().getContent("D:/java/JavaCore_CoBan_ChuyenSau.pdf");
		//for (int i=0; i<arr.length; i++){
			System.out.println(line);
		//}
		
	}

	public boolean validateFile(String[] param) { // 0-path, 1-extension,
													// 2-size, 3-sizeType,
													// 4-content
		if ((checkExtension(param[0], param[1])) && (checkSize(param[0], param[2], param[3]))
				&& (checkContent(param[0], param[4]))) {
			return true;
		}
		return false;
	}

}
