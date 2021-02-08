'''Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
  Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: candidates = [2], target = 1
Output: []
Example 4:
Input: candidates = [1], target = 1
Output: [[1]]
Example 5:
Input: candidates = [1], target = 2
Output: [[1,1]]
  Constraints:
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500''' 
from typing import List


class Solution:

    def __init__(self):
        self.memo = {}  # target

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if len(candidates) == 0:
            return None
        if len(candidates) == 1:
            if target % candidates[0] == 0:
                return [[candidates[0]] * (target//candidates[0])]
        if self.memo.__contains__(target):
            return self.memo[target]

        ans = []
        if candidates.__contains__(target):
            ans.append([target])
        for i in range(1, target):
            # print(candidates,target+1)
            tmp_candidates = [x for x in candidates if x <= i]
            cand1 = (self.combinationSum(tmp_candidates, i))
            tmp_candidates = [x for x in candidates if x <= target - i]
            cand2 = (self.combinationSum(tmp_candidates, target - i))
            # print("cand1", cand1, "cand2", cand2)
            if cand1 is not None and cand2 is not None:
                for c1 in cand1:
                    for c2 in cand2:
                        c0 = c1+c2
                        c0.sort()
                        # print("c0", c0, "c1", c1, "c2", c2, "cand1", cand1)
                        if not ans.__contains__(c0):
                            ans.append(c0.copy())
        self.memo[target] = list(ans)
        return ans
