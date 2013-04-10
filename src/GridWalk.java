//
//  GridWalk.java
//  
//
//  Created by Ryan Barril on 10/6/12.
//  Copyright 2012 __MyCompanyName__. All rights reserved.
//

/*
There is a monkey which can walk around on a planar grid. The monkey can move one space at a time left, right, up or down. 
That is, from (x, y) the monkey can go to (x+1, y), (x-1, y), (x, y+1), and (x, y-1). Points where the sum of the digits of the absolute value 
of the x coordinate plus the sum of the digits of the absolute value of the y coordinate are lesser than or equal to 19 are accessible to the monkey. 
For example, the point (59, 79) is inaccessible because 5 + 9 + 7 + 9 = 30, which is greater than 19. Another example: the point (-5, -7) is accessible 
because abs(-5) + abs(-7) = 5 + 7 = 12, which is less than 19. How many points can the monkey access if it starts at (0, 0), including (0, 0) itself? 
 */

import java.util.*;
import java.lang.Math;

class GridWalk {
	
	// List to iterate over all reachable locations. Map determines if location is visited.
	static List<Location> reachables = new LinkedList<Location>();
	static Map<Location, Boolean> visited = new HashMap<Location, Boolean>();
	
	// Standard 2D-coordinates class.
	static class Location {
		int x, y;
		
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object in) {
			Location arg = (Location) in;
			if (arg == null) return false;
			return (x == arg.x && y == arg.y);
		}
		
		public int hashCode() {
			return this.x + this.y;
		}
	}
	
	// Mark location as visited and add adjacent locations if they are newly found and accessible/reachable.
	void visit(Location loc) {
		visited.put(loc, true);
		
		Location left = new Location(loc.x - 1, loc.y);
		Location right = new Location(loc.x + 1, loc.y);
		Location up = new Location(loc.x, loc.y + 1);
		Location down = new Location(loc.x, loc.y - 1);
		
		addIfNewAccessibleLocation(left);
		addIfNewAccessibleLocation(right);
		addIfNewAccessibleLocation(down);
		addIfNewAccessibleLocation(up);
	}
	
	// Add accessible location to reachable list if not already in reachable list.
	void addIfNewAccessibleLocation(Location loc) {
		if (!visited.containsKey(loc) && isAccessible(loc)) {
			reachables.add(loc);
			visited.put(loc, false);
		}
	}
	
	// Condition for whether or not a 2D location is accessible.
	boolean isAccessible(Location loc) {
		return (sumDigits(loc.x) + sumDigits(loc.y) <= 19);
	}
	
	// Method which sums the digits of a number.
	int sumDigits(int n) {
		if (n == 0) return 0;
		n = Math.abs(n);
		return (n % 10) + sumDigits(n / 10);
	}
	
	// Initialize reachable list with starting position.
	// Continually add reachable locations adjacent to already-added reachable locations.
	public static void main(String[] args) {
		GridWalk gw = new GridWalk();
		Location start = new Location(0, 0);
		reachables.add(start);
		
		int index = 0;
		while (true) {
			if (index >= reachables.size())
				break;
			gw.visit(reachables.get(index));
			index++;
		}
		System.out.println(reachables.size());
	}
	
}
