class Solution {
    public static boolean checkStraightLine(int[][] coordinates) {
    	if (coordinates.length == 2) return true;
    	
    	for(int i = 2; i < coordinates.length; i++) {
			//y = a*x +c - the line formula
    		//a1 = (y1- y2) / (x1 - x2)
    		//ai = (y1- yi) / (x1 - xi)
    		//a1 == ai iff (y1-y2) / (x1 - x2) == (y1- yi) / (x1 - xi)
    		//arrange terms (y1-y2)*(x1 - xi) == (y1- yi) * (x1 - x2)
    		int x1 = coordinates[0][0];
    		int y1 = coordinates[0][1];
    		int x2 = coordinates[1][0];
    		int y2 = coordinates[1][1];
    		int xi = coordinates[i][0];
    		int yi = coordinates[i][1];
    		if ((y1-y2)*(x1 - xi) != (y1- yi) * (x1 - x2)) return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		int [][] test = {{1,2},{2,3},{5,1}};
		System.out.println(checkStraightLine(test));
	}
}
