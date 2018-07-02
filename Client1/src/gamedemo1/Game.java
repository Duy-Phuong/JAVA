/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamedemo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;

public class Game {

	public static final int WIDTH = 64-10;
	public static final int HEIGHT = 36-10;
	public static final int FRUITS = 3;
	public static final int TICK = 100;
	
	public int field[][] = new int[WIDTH][HEIGHT];
	public static ArrayList<Player> players = new ArrayList<>();
	private Random rnd = new Random();
	public ArrayList<Integer> fruitsX = new ArrayList<>();
	public ArrayList<Integer> fruitsY = new ArrayList<>();
	public static ArrayList<Integer> solidsX = new ArrayList<>();
	public static ArrayList<Integer> solidsY = new ArrayList<>();
	public int highscore = 0;
	public static boolean deadPlayersBecomeSolids = false;
	
	
	public Game() {
		
		for (int i = 0; i < FRUITS; i++) {
			fruitsX.add(rnd.nextInt(WIDTH-40));
			fruitsY.add(rnd.nextInt(HEIGHT-20));
		}
		
	}

	public void update() {

		move();
		checkCollisions();
		checkSolids();
		checkFruits();
		
		updateField();
		
	}
	
	private void move() {
		
		for (Player p : players) {
			if (p == null) continue;
			p.move();
		}
		
	}
	
	private void checkCollisions() {
		
		outerLoop:
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			if (p == null) continue;
			
			// borders
			if (	Collections.max(p.segmentsX) >= WIDTH ||
					Collections.max(p.segmentsY) >= HEIGHT ||
					Collections.min(p.segmentsX) < 0 ||
					Collections.min(p.segmentsY) < 0) {
				
				// dead
				if (deadPlayersBecomeSolids) playerToSolids(p);
				players.set(i, null);
				continue;
				
			}
			
			// other players
			int pX = p.segmentsX.get(0);
			int pY = p.segmentsY.get(0);
			for (Player q : players) {
				if (q == null) continue;
				
				if (p == q) {
					
					for (int d = 1; d < q.segmentsX.size(); d++) {
						if (q.segmentsX.get(d) == pX && q.segmentsY.get(d) == pY) {
							
							// dead
							if (deadPlayersBecomeSolids) playerToSolids(p);
							players.set(i, null);
							continue outerLoop;
							
						}
						
					}
					
				} else if (p != q && q.segmentsX.contains(pX) && q.segmentsY.contains(pY)) {
                                    
                                      //    JOptionPane.showMessageDialog(null, "dung nhau");
//                                    int qX = q.segmentsX.get(0);
//                                    int qY = q.segmentsY.get(0);
//                                    if(qX == pX && qY == pY){
                                      //  JOptionPane.showMessageDialog(null, "dung nhau");
                                         System.out.println("-----------------------dung -------------");
					// dead
					if (deadPlayersBecomeSolids) playerToSolids(p);
					players.set(i, null);
					continue outerLoop;
                                    }
                                   
					
				//}
				
			}
			
		}
		
	}
	public static void PlayAgainst() {
		
		outerLoop:
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			if (p == null) continue;
			
			
				// dead
				if (deadPlayersBecomeSolids) playerToSolids(p);
				players.set(i, null);
				continue;

			
		}
		
	}
	private void checkSolids() {
		
		outerLoop:
		for (int i = 0; i < players.size(); i++) {
			Player p = players.get(i);
			if (p == null) continue;
			
			for (int j = 0; j < solidsX.size(); j++) {
				
				if (p.segmentsX.get(0) == solidsX.get(j) && p.segmentsY.get(0) == solidsY.get(j)) {

					int result = fruitsX.indexOf(solidsX.get(j));
					if (result > -1 && fruitsY.get(result) == solidsY.get(j)) {
						
						// don't die when fruit overlaps solid
						
					} else {

						// dead
						if (deadPlayersBecomeSolids) playerToSolids(p);
						players.set(i, null);
						continue outerLoop;
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private void checkFruits() {
		
		for (Player p : players) {
			if (p == null) continue;
			
			for (int i = 0; i < FRUITS; i++) {
				
				if (p.segmentsX.get(0) == fruitsX.get(i) && p.segmentsY.get(0) == fruitsY.get(i)) {
					// vt moi
					fruitsX.set(i, rnd.nextInt(WIDTH-15));
					fruitsY.set(i, rnd.nextInt(HEIGHT-10));
					
					p.score++;
					p.updateScore = true;
					
				}
				
			}
			
		}
		
	}
	
	private void updateField() {
		
		field = new int[WIDTH][HEIGHT];

		// solids
		for (int i = 0; i < solidsX.size(); i++) {
			
			// safezone
			if (solidsX.get(i) < 3 && solidsY.get(i) < 3) {
				solidsX.remove(i);
				solidsY.remove(i);
				continue;
			}
			
			field[solidsX.get(i)][solidsY.get(i)] = -1;
		}
		
		// fruits
		for (int i = 0; i < FRUITS; i++) {
			field[fruitsX.get(i)][fruitsY.get(i)] = 1;
		}
		
		// players
		for (Player p : players) {
			if (p == null) continue;
			
			// segments
			for (int i = 0; i < p.segmentsX.size(); i++) {
				field[p.segmentsX.get(i)][p.segmentsY.get(i)] = p.id;
			}
			
			// head
			field[p.segmentsX.get(0)][p.segmentsY.get(0)] = -p.id;
			
		}
		
	}
	
	private static void playerToSolids(Player p) {
		
		for (int i = 0; i < p.segmentsX.size(); i++) {
			int x = p.segmentsX.get(i);
			int y = p.segmentsY.get(i);
			if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
				solidsX.add(x);
				solidsY.add(y);
			}
		}
		
	}
	
}