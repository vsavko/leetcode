'''Implement the StreamChecker class as follows:
StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
  Example:
StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
  Note:
1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000.''' 
from typing import List


class StreamChecker:

    def __init__(self, words: List[str]):
        self.wordsSet = Trie(words)
        self.letters = ""

    def query(self, letter: str) -> bool:
        self.letters += letter
        tmpLetterSequence = ""
        for i in range(len(self.letters)-1,-1,-1):
            tmpLetterSequence += self.letters[i]
            if not self.wordsSet.isPrefix(tmpLetterSequence):
                return False
            if self.wordsSet.hasWord(tmpLetterSequence):
                return True
        return False


class Node:
    def __init__(self):
        self.children = [None] * 26
        self.end = False


class Trie:
    def __init__(self, words):
        self.root = Node()
        for word in words:
            tmpRoot = self.root
            for j in range(len(word) -1 , -1, -1):
                letter = word[j]
                if tmpRoot.children[ord(letter)-ord('a')] is None:
                    tmpRoot.children[ord(letter)-ord('a')] = Node()
                tmpRoot = tmpRoot.children[ord(letter)-ord('a')]
            tmpRoot.end = True

    def isPrefix(self, word):
        tmpRoot = self.root
        for letter in word:
            if tmpRoot.children[ord(letter) - ord('a')] is None:
                return False
            tmpRoot = tmpRoot.children[ord(letter) - ord('a')]
        return True

    def hasWord(self, word):
        tmpRoot = self.root
        for letter in word:
            if tmpRoot.children[ord(letter) - ord('a')] is None:
                return False
            tmpRoot = tmpRoot.children[ord(letter) - ord('a')]
        if tmpRoot.end:
            return True
        return False
