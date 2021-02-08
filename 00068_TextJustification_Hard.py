'''Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
  Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
  Constraints:
1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth''' 
from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        chars = 0
        word_buffer = []
        ans = []
        for word in words:
            # print(word, word_buffer, chars)
            chars += len(word)
            # print(word, word_buffer, chars)
            if chars == maxWidth:
                word_buffer.append(word)
                tmp_word = ''

                for w in range(0, len(word_buffer)):
                    tmp_word += word_buffer[w]
                    if w < len(word_buffer) - 1:
                        tmp_word += ' '

                ans.append(tmp_word)
                chars = 0
                word_buffer = []
            elif chars > maxWidth:
                # calc spaces:
                # print(chars)
                chars -= len(word)

                extra_spaces = maxWidth - chars +1
                spaces_buffer = [0] * (len(word_buffer) - 1)
                tmp_word = ''

                for i in range(0, extra_spaces):
                    if len(spaces_buffer)> 0 :
                        spaces_buffer[i % len(spaces_buffer)] += 1

                for w in range(0, len(word_buffer)):
                    tmp_word += word_buffer[w]
                    if w < len(word_buffer) - 1:
                        tmp_word += ' '
                        tmp_word += ' ' * spaces_buffer[w]

                if len(word_buffer) == 1:
                    while(extra_spaces >0):
                        tmp_word += ' '
                        extra_spaces -=1

                ans.append(tmp_word)
                chars = len(word)
                chars += 1

                word_buffer = []
                word_buffer.append(word)
            else:
                word_buffer.append(word)
                chars += 1  # add extra space
            # print(word_buffer)
        if len(word_buffer) > 0:
            tmp_word = ''
            for w in range(0, len(word_buffer)):
                tmp_word += word_buffer[w]
                if w < len(word_buffer) - 1:
                    tmp_word += ' '
            extra_spaces = maxWidth - chars +1
            while (extra_spaces > 0):
                tmp_word += ' '
                extra_spaces -= 1

            ans.append(tmp_word)
        return ans

