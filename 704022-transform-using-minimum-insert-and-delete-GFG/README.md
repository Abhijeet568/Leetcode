# [Transform using Minimum Insert and Delete](https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1)
## Medium
Given two strings s1 and s2. The task is to remove or insert the minimum number of characters from/in s1 to transform it into s2. It could be possible that the same character needs to be removed from one point of s1 and inserted into another point.
Examples :
Input: s1 = "heap", s2 = "pea"
Output: 3
Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.
Input : s1 = "geeksforgeeks", s2 = "geeks"
Output: 8
Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".