package PrimMST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadText {
	String fileToLoad;
	int length = 0;
	public LoadText(String fileName) throws FileNotFoundException {
		fileToLoad = fileName;
		System.out.println(fileName);
		size();
	}

	public void size() throws FileNotFoundException {
		int size = 0;
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		while(myReader.hasNextLine()) {
			size ++;
			myReader.nextLine();
			//System.out.println("Length of Input: " + size);
		}
		//myReader.close();
		length = size;
		System.out.println("Length of Input: " + size);
	}

	public ArrayList<edge> get() throws FileNotFoundException {
		ArrayList<edge> initData = new ArrayList<edge>(length - 1);
		//System.out.println(length);
		File myObj = new File(fileToLoad);
		Scanner myReader = new Scanner(myObj);
		int numOfVer = 0;
		while(myReader.hasNextLine()) {
			String[] data = myReader.nextLine().split("\\s");
			if(data.length < 3) {
				numOfVer = Integer.parseInt(data[0]);
				continue; // starting line
			}
			edge node = new edge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), numOfVer);
			initData.add(node);
		}
		myReader.close();
		return initData;
	}
}
