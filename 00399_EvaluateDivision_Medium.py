'''You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
Return the answers to all queries. If a single answer cannot be determined, return -1.0.
Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
  Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
  Constraints:
1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.''' 
from typing import List


class UnionFind:
    values_list = []
    parent_list = []
    relation_list = []
    dct = {}
    def __init__(self, pairs, values):
        self.values_list = list(set(x for lst in pairs for x in lst))
        self.relation_list = [1.0] * len(self.values_list)
        self.parent_list = [x for x in range(0,len(self.values_list))]
        keys = range(len(self.values_list))
        self.dct = dict(zip(self.values_list,keys)) #store the position of the element from 
            values_list in the parent_list

        for id in range(0,len(pairs)):
            pair = pairs[id]
            val = values[id]
            root_id = self.find_root(self.dct[pair[0]],1)
            self.parent_list[root_id[0]] = self.dct[pair[1]]
            self.relation_list[root_id[0]] = root_id[1] * val

        for id in range(0,len(self.parent_list)):
            self.fix_root(id)

    def find_root(self, id, val):
        if (id == self.parent_list[id]):
            return [id, val]
        root_id = self.find_root(self.parent_list[id], val/self.relation_list[id])
        return root_id

    def fix_root(self, id):
        if (id == self.parent_list[id]):
            return [id, 1]
        tmp = self.fix_root(self.parent_list[id])
        self.parent_list[id] = tmp[0]
        self.relation_list[id] *= tmp[1] #if all elements are allready set we multiply by the 
            last element - 1.0
        return [tmp[0], self.relation_list[id]]


    def does_exist(self, key_pair):
        key1 = key_pair[0]
        key2 = key_pair[1]
        if not self.dct.__contains__(key1) or not self.dct.__contains__(key2):
            return False
        if self.parent_list[self.dct[key1]] != self.parent_list[self.dct[key2]]:
            return False
        return True

    def get_relation(self, key):
        return self.relation_list[self.dct[key]]

    
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: 
        List[List[str]]) -> List[float]:
        uf = UnionFind(equations, values)
        ans = []
        for q in queries:
            if not uf.does_exist(q):
                ans.append(-1.0)
            else:
                ans.append(uf.get_relation(q[0])/uf.get_relation(q[1]))
        return ans
