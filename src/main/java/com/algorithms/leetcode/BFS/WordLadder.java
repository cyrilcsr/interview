package com.algorithms.leetcode.BFS;

import java.util.*;

/*
Leeetcode 0127
 */
public class WordLadder {
    //单向bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Map<String,Integer> visited = new HashMap<>();
        Deque<String> possibleWords = new ArrayDeque<>();
        visited.put(beginWord,1);
        possibleWords.offer(beginWord);
        while(!possibleWords.isEmpty()){
            char[] word = possibleWords.peek().toCharArray();
            for(int i=0;i<word.length;i++){
                char original = word[i];
                int step = visited.get(new String(word));
                for(char c='a';c<='z';c++){
                    word[i] = c;
                    String s = new String(word);
                    if(words.contains(s)&& !visited.containsKey(s)){
                        visited.put(s,step+1);
                        possibleWords.offer(s);
                    }
                    if(s.equals(endWord)) break;
                }
                word[i] = original;
            }
            possibleWords.poll();
        }

        return visited.getOrDefault(endWord,0);
    }

    //双向BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet(wordList);
        if(wordList.size()==0 || !dict.contains(endWord)) {
            return 0;
        }
        HashSet<String> beginVisited = new HashSet();
        HashSet<String> endVisited = new HashSet();
        HashSet<String> visited = new HashSet();
        int step = 1;

        beginVisited.add(beginWord);
        endVisited.add(endWord);
        while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            if(beginVisited.size() > endVisited.size()){
                HashSet<String> tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = tmp;
            }
            HashSet<String> nextLevelVisited = new HashSet();
            for(String word : beginVisited) {
                if(explorWord(word, endVisited, nextLevelVisited, visited, dict)){
                    return step + 1;
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;

    }
    public boolean explorWord(String word, HashSet<String> endVisited, HashSet<String> nextLevelVisited,HashSet<String> visited,HashSet<String> dict ) {
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char cur = ca[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if(c == cur) {
                    continue;
                }
                ca[i] = c;
                String nextWord = String.valueOf(ca);
                if(dict.contains(nextWord)) {
                    if(endVisited.contains(nextWord)) {
                        return true;
                    }
                    if(!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }

            }
            ca = word.toCharArray();
        }
        return false;
    }
}
