package swt;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

public class FileClass {
	public String getExtension(String path) {
		return FilenameUtils.getExtension(path);
	}

	public long getSize(String path, String type) {
		long sizeType = 1;
		if (type.equalsIgnoreCase("MB")) {
			sizeType = 1024 * 1024;
		}
		if (type.equalsIgnoreCase("KB")) {
			sizeType = 1024;
		}
		File file = new File(path);
		return file.length() / sizeType;
	}

	public void parseFile(String fileName, String searchStr) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName));
			while (scan.hasNext()) {
				String line = scan.nextLine().toString();
				if (line.contains(searchStr)) {
					System.out.println("Result line: " + line);
				}
			}
			System.out.println("end");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkContent(String path, String searchStr) {
		try {
			FileInputStream fstream = new FileInputStream("D://test.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains(searchStr)) {
					return true;
				}
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new FileClass().getExtension("D://producer.json"));
		System.out.println(new FileClass().getSize("D://test.txt", "b"));
		//new FileClass().readLineFile("D://test.docx","12");
	}
}
