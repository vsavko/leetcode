/*Implement the RandomizedSet class:
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
Follow up: Could you implement the functions of the class with each function works in average O(1) time?
  Example 1:
Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
  Constraints:
-231 <= val <= 231 - 1
At most 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.*/ 
class RandomizedSet {
    HashMap<Integer,Integer> set;
    int elementsInArr;
    int emptySpaces;
    Integer [] arr;
    int currentPos;
    int nullValues;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashMap<>();
        arr = new Integer[10];
        currentPos = 0;
        nullValues = 10;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the 
        specified element. */
    public boolean insert(int val) {
        if (set.containsKey(val)) return false;
        if (currentPos > arr.length -1) {
            
            Integer [] arrTmp = new Integer[arr.length*2];
            Arrays.fill(arrTmp, null);
            for(int i = 0; i < arr.length; i++) {
                arrTmp[i] = arr[i];
            }
            //System.out.println("tmp len" + arrTmp.length);
            nullValues += arr.length;
            arr = arrTmp;
        }
        //System.out.println(currentPos + " arr len " + arr.length);
        set.put(val,currentPos);
        arr[currentPos++] = val;
        --nullValues;
        //System.out.println(nullValues);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. 
        */
    public boolean remove(int val) {
        if (!set.containsKey(val)) return false;
        int pos = set.get(val);
        set.remove(val);
        arr[pos] = null;
        ++nullValues;
       
        if( (nullValues > 3*arr.length/4) && arr.length >= 20) {
             System.out.println("nullValues " + nullValues  + arr.length + " arr.length/");
            Integer [] arrTmp = new Integer[arr.length/2];
            int j =0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != null) {
                    arrTmp[j] = arr[i];
                    set.replace(arr[i], j);
                    j++;
                }
            }
            arr = arrTmp;
            elementsInArr = j-1;
            nullValues = arr.length - elementsInArr;
            currentPos = j;
        }
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomNum;
        do {
            randomNum = ThreadLocalRandom.current().nextInt(0, arr.length);
            //System.out.println(randomNum);
        }while (arr[randomNum] == null);
        
        return arr[randomNum] ;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
