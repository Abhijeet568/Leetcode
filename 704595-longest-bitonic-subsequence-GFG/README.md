# [Longest Bitonic Subsequence](https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1)
## Medium
Given an array of positive integers. Find&nbsp;the maximum length of Bitonic subsequence.&nbsp; A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.&nbsp;Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence
Examples :
Input: n = 5, nums[] = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence [1, 2, 5] is increasing and the sequence [3, 2] is decreasing so merging both we will get length 5.

Input: n = 8, nums[] = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence [1, 2, 10, 4, 2, 1] has length 6.
Input: n = 3, nums[] = [10, 20, 30]
Output: 0
Explanation: The decreasing or increasing part cannot be empty.
Input: n = 3, nums[] = [10, 10, 10]
Output: 0
Explanation: No strictly increasing or decreasing sequence exists.

Constraints:1 ≤&nbsp;length of array ≤ 1031 ≤ arr[i] ≤ 104