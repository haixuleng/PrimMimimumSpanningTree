package PrimMST;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestLoadText {
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/edges.txt");
		ArrayList<edge> data = lt.get();
		for(edge i : data) {
			System.out.println(i.vertex1 + ", " + i.vertex2 + ", " + i.cost);
		}
	}
}
