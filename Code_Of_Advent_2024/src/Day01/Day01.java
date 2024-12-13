package Day01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {
	private static int solution1 = 0;
	private static int solution2 = 0;
	static Scanner in;

	
	public static void main(String[] args)   {
		Day01 day01 = new Day01();
		Day01.solution(day01);
		System.out.println("Solution 1: " + day01.getSolution1());
		System.out.println("Solution 2: " + day01.getSolution2());
		
		

	}

	private static void solution(Day01 day01) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> listLeft = new ArrayList<Integer>();
		ArrayList<Integer> listRight = new ArrayList<Integer>();
		
		try {
			in = new Scanner(new FileReader("./src/Day01/Day01.txt"));
			while(in.hasNext()) {
				sb = new StringBuilder().append(in.nextLine());
				String temp = sb.toString();
				listLeft.add(Integer.parseInt(temp.toString().split("   ")[0]));
				listRight.add(Integer.parseInt(temp.toString().split("   ")[1]));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not Found");
		} finally {
			in.close();
		}
		
		solution1 = solution01(listLeft, listRight); 
		solution2 = solution02(listLeft, listRight);
	}

	
	private static int solution02(ArrayList<Integer> listLeft, ArrayList<Integer> listRight) {
		ArrayList<Integer> l = listLeft;
		ArrayList<Integer> r = listRight;
				
		Collections.sort(l);
		Collections.sort(r);
		
		int result = 0;
		
		for (int i = 0; i < l.size(); i++) {
			
			int counter = 0, temp = l.get(i);
			for (int j = 0; j < l.size(); j++) {
				if (temp == r.get(j)) {
					counter++;
				}
			}
			
			result += (temp*counter);
		}
		
		return result;
	}

	private static int solution01(ArrayList<Integer> listLeft, ArrayList<Integer> listRight) {
		ArrayList<Integer> l = listLeft;
		ArrayList<Integer> r = listRight;
				
		Collections.sort(l);
		Collections.sort(r);
		
		int result = 0;
		
		for (int i = 0; i < l.size(); i++) {
			result += Math.abs(l.get(i) - r.get(i));
		}
		
		return result;
	}

	
	
	

	public int getSolution1() {
		return solution1;
	}

	public void setSolution1(int solution1) {
		this.solution1 = solution1;
	}

	public int getSolution2() {
		return solution2;
	}

	public void setSolution2(int solution2) {
		this.solution2 = solution2;
	}

}
