package com.syh.algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 */
public class FindSubstring {

    public static void main(String[] args) {
        System.out.println(new FindSubstring().findSubstring("barfoothefoobarman"
                , new String[]{"foo", "bar"}));
        System.out.println(new FindSubstring().findSubstring("wordgoodgoodgoodbestword"
                , new String[]{"word", "good", "best", "word"}));
        System.out.println(new FindSubstring().findSubstring("barfoofoobarthefoobarman"
                , new String[]{"bar", "foo", "the"}));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return list;
        }
        int wordOneLen = words[0].length();
        int wordsLen = words.length;
        int allLen = wordsLen * wordOneLen;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        out:
        for (int i = 0; i < s.length() - allLen + 1; i++) {
            Map<String, Integer> tmpMap = new HashMap<>();
            int start = i;
            while (start + wordOneLen < i + allLen + 1) {
                String currStr = s.substring(start, start + wordOneLen);
                tmpMap.put(currStr, tmpMap.getOrDefault(currStr, 0) + 1);
                int currTmpCount = tmpMap.getOrDefault(currStr, 0);
                int currMapCount = map.getOrDefault(currStr, 0);
                if (currMapCount == 0 || currTmpCount > currMapCount) {
                    continue out;
                }
                start += wordOneLen;
            }
            list.add(i);
        }
        return list;
    }
}
