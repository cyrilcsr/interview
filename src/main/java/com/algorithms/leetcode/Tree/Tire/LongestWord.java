package com.algorithms.leetcode.Tree.Tire;

/*
Leeetcode 0720
*/

public class LongestWord {
    class Tire{
        Tire[] children;
        char letter;
        boolean isWord;
        Tire(Tire[] children,char letter, boolean isWord){
            this.children = new Tire[26];
            this.letter = letter;
            this.isWord = isWord;
        }

        public void insert(String word){
            if(word==null||word.length()==0){
                return;
            }
            Tire node = this;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a'] = new Tire(new Tire[26],c,false);
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;
        }

        public boolean search(String word){
            Tire node = this;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(node.children[c-'a']==null|| !node.children[c - 'a'].isWord){
                    return false;
                }
                node = node.children[c-'a'];
            }
            return true;
        }

    }
    public String longestWord(String[] words) {
        Tire root = new Tire(new Tire[26],(char)0,false);
        for(String word:words){
            root.insert(word);
        }

        String result = "";
        for (String word : words) {
            if (root.search(word)) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }
}
