package PrimMST;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

public class PrimNaive{
	public static void main(String args[]) throws FileNotFoundException {
		LoadText lt = new LoadText("data/edges.txt");
		//LoadText lt = new LoadText("data/input_random_29_800.txt");
		ArrayList<edge> data = lt.get();
		HashSet<Integer> X = new HashSet<Integer>();
		HashSet<Integer> V = new HashSet<Integer>();
		ArrayList<edge> T = new ArrayList<edge>();
		
		// Initialize
		edge s = data.get(0);
		X.add(s.vertex1);
		for(int i = 1; i <= s.numberOfVertex; i++) {
			V.add(i);
		}
		
		// Loop
		while(X.size() != V.size()) {
			edge cheapest = cheapestEdge(data, X);
			X.add(cheapest.vertex1);
			X.add(cheapest.vertex2);
			T.add(cheapest);
		}
		
		// Get total cost
		long totalCost = 0;
		for(edge i : T) {
			totalCost = totalCost + i.cost;
		}
		System.out.println("Total cost is: " + totalCost);
	}
	
	public static edge cheapestEdge(ArrayList<edge> data, HashSet<Integer> X) {
		edge cheapest = new edge(0, 0, Integer.MAX_VALUE, 0);
		for(edge i : data) {
			if(X.contains(i.vertex1) && X.contains(i.vertex2)) {
				continue; // both are in X
			}
			else if(!X.contains(i.vertex1) && !X.contains(i.vertex2)) {
				continue; // both are not in X
			}
			if(i.cost < cheapest.cost) {
				cheapest = i; // swap i to be the cheapest
			}
		}
		
		return cheapest;
	}
}