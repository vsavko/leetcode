'''Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().
Follow up:
What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
  Example 1:
Input: n = 1
Output: [2]
Example 2:
Input: n = 2
Output: [2,8]
Example 3:
Input: n = 3
Output: [3,8,10]
  Constraints:
1 <= n <= 105''' 
# The rand7() API is already defined for you.
# def rand7():
# @return a random integer in the range 1 to 7

class Solution:
    def rand10(self):
        """
        :rtype: int
        """
        num = 0
        while True:
            num = rand7()
            if num != 7:
                break
        
        ans = 0
        while True:
            if num <= 3:
                ans = rand7()
                if ans < 6:
                    break
            else:
                ans = rand7()
                if ans < 6:
                    ans += 5
                    break
        return ans
