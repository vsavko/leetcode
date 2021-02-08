'''Design the CombinationIterator class:
CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
  Example 1:
Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False
  Constraints:
1 <= combinationLength <= characters.length <= 15
All the characters of characters are unique.
At most 104 calls will be made to next and hasNext.
It's guaranteed that all calls of the function next are valid.''' 
class CombinationIterator:
    def __init__(self, characters: str, combinationLength: int):
        self.comboList = []
        self.comboLen = combinationLength
        self.string = characters
        for i in range(combinationLength):
            self.comboList.append(i)
        print(len(self.string) )

    def next(self):
        ans = ""
        print(self.comboList)
        if not self.hasNext():
            return ans
        for i in self.comboList:
            ans += self.string[i]
        for i in range (len(self.comboList)-1, -1, -1):
            print(i, " ", self.comboList[i], " " , len(self.string) - 1)
            if i == 0 or self.comboList[i] + len(self.comboList) - i < len(self.string) :
                self.comboList[i] += 1
                iPosition = self.comboList[i] + 1
                for j in range(i + 1, len(self.comboList)):
                    self.comboList[j] = iPosition
                    iPosition += 1
                break
        print(self.comboList)
        return ans

    def hasNext(self):
        if self.comboList[0] <= len(self.string) - self.comboLen:
            return True
        return False



# Your CombinationIterator object will be instantiated and called as such:
# obj = CombinationIterator(characters, combinationLength)
# param_1 = obj.next()
# param_2 = obj.hasNext()
