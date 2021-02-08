/*We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
  Example 1:
Input: poured = 1, query_row = 1, query_glass = 1
Output: 0.00000
Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
Example 2:
Input: poured = 2, query_row = 1, query_glass = 1
Output: 0.50000
Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
Example 3:
Input: poured = 100000009, query_row = 33, query_glass = 17
Output: 1.00000
  Constraints:
0 <= poured <= 109
0 <= query_glass <= query_row < 100*/ 
class Solution {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double [] glass_row = new double[query_row+1];
        glass_row[0] = poured;
        if (query_row == 0 && query_glass == 0) return glass_row[0] > 1 ? 1 : glass_row[0];
        for(int i = 1; i <= query_row; i++){
            double [] glass_row_tmp = new double[query_row+1];
            for(int j = 0; j < i + 1; j++){
                if(j == 0)  glass_row_tmp[0] = Math.max(0, 0.5*(glass_row[0] - 1));
                else if(j == i)  glass_row_tmp[j] = Math.max(0, 0.5*(glass_row[i-1] - 1));
                else glass_row_tmp[j] = Math.max(0, 0.5*(glass_row[j-1]-1)) + Math.max(0, 0.5
                    *(glass_row[j]-1));
                if (i == query_row && j == query_glass) return glass_row_tmp[j] > 1 ? 1 : 
                    glass_row_tmp[j];
            }
            glass_row = glass_row_tmp;
        }
        return 0;
    }
}
