package com.advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Advent2022 {
	
	private static void firstPuzzle() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("/Users/vn50n8q/Documents/GitHub/vudph/AdventOfCode/src/main/resources/calo.txt"));
			String line = reader.readLine();
			int max = 0;
			int s = 0;
			int max1 = 0, max2 = 0, max3 = 0;
			while (line != null) {
				System.out.println(line);
				if (line.equals("")) {
//					max = Math.max(max, s);
					
					if (s > max1) {						
						int tmp = max2;
						max2 = max1;
						max3 = tmp;
						max1 = s;
					} else if (s > max2) {
						max3 = max2;
						max2 = s;
					} else if (s > max3) {
						max3 = s;
					}
					
					s = 0;
				} else {
					s += Integer.parseInt(line);
				}
				// read next line
				line = reader.readLine();
			}

			reader.close();
			System.out.println(max1 + max2 + max3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void secondPuzzle() {
		BufferedReader reader;
		List<String[]> input = new ArrayList<String[]>();
		try {
			reader = new BufferedReader(new FileReader("/Users/vn50n8q/Documents/GitHub/vudph/AdventOfCode/src/main/resources/rock.txt"));
			String line = reader.readLine();
			int point = 0;
			Map<String, Integer> topoint = new HashMap<String, Integer>();
			topoint.put("A X", 3);
			topoint.put("A Y", 6);
			topoint.put("A Z", 0);
			topoint.put("B X", 0);
			topoint.put("B Y", 3);
			topoint.put("B Z", 6);
			topoint.put("C X", 6);
			topoint.put("C Y", 0);
			topoint.put("C Z", 3);
			
			while (line != null) {
				System.out.println(line);
				String[] g = line.split(" ");
//				input.add(g);
//				A for Rock, B for Paper, and C for Scissors
//				X for Rock, Y for Paper, and Z for Scissors
//				Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock. If both players choose the same shape, then a draw.
				
				if (g[1].equals("X"))
					point += 1;
				else if (g[1].equals("Y"))
					point += 2;
				else if (g[1].equals("Z"))
					point += 3;
				point += topoint.get(line);
				
				// read next line
				line = reader.readLine();
			}
			reader.close();
			System.out.println(point);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(input.size());
		
	}

	public static void main(String[] args) {
		secondPuzzle();
	}

}
