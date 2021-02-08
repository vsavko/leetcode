/*Design a HashSet without using any built-in hash table libraries.
Implement MyHashSet class:
void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
  Example 1:
Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
  Constraints:
0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.
  Follow up: Could you solve the problem without using the built-in HashSet library?*/ 
class MyHashSet {
     private LinkedList<Integer>[] hashMap;
        
        /** Initialize your data structure here. */
        @SuppressWarnings("unchecked")
        public MyHashSet() {
            hashMap = new LinkedList[10000];
        }
        
        public void add(int key) {
            if (contains(key)) return;
            int hashKey = key % 10000;
            if (hashMap[hashKey] == null)
                hashMap[hashKey] = new LinkedList<Integer>();
            hashMap[hashKey].add(key);
        }
        
        public void remove(int key) {
            if(contains(key)){
                int hashKey = key % 10000;
                hashMap[hashKey].remove((Integer)key);
            }
        }
        
        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hashKey = key % 10000;
            if (hashMap[hashKey] == null) return false;
            if (!hashMap[hashKey].contains(key)) return false;
            return true;
        }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
