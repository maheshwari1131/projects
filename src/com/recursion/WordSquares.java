package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of unique strings words, return all the word squares you can build from words. The same word from words can be used multiple times. You can return the answer in any order.
 *
 * A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).
 *
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 *
 *
 * Example 1:
 *
 * Input: words = ["area","lead","wall","lady","ball"]
 * Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * Example 2:
 *
 * Input: words = ["abat","baba","atan","atal"]
 * Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 *
 */
public class WordSquares {
    static int N=0;
    static HashMap<String,List<String>> prefixHashTable;
    String[] words=null;

    public static void main(String args[]){
        String[] s={"area", "lead","ball","lady"};
        wordSquares(s);
    }
    public static List<List<String>> wordSquares(String[] words) {
        words=words;
        N=words[0].length();
        List<List<String>> results=new ArrayList<List<String>>();
        buildPrefixHashTable(words);
        for(String word:words){
            LinkedList<String> wordSquares=new LinkedList<String>();
            wordSquares.addLast(word);
            backtracking(1,wordSquares, results);

        }
        return results;


    }

    protected static void backtracking(int step, LinkedList<String> wordSquares, List<List<String>> results){
        if(step==N){
            results.add((List<String>) wordSquares.clone());
            return;
        }
        StringBuilder prefix=new StringBuilder();
        for(String word: wordSquares){
            prefix.append(word.charAt(step));
        }

        for(String candidate:getWordsWithPrefix(prefix.toString())){
            wordSquares.addLast(candidate);
            backtracking(step+1,wordSquares, results);
            wordSquares.removeLast();
        }
    }

    static void buildPrefixHashTable(String[] words){
        prefixHashTable=new HashMap<String,List<String>>();
        for(String word:words){
            for(int i=1;i<N;++i){
                String prefix=word.substring(0,i);
                List<String> wordList=prefixHashTable.get(prefix);
                if(wordList==null){
                    wordList=new ArrayList<String>();
                    wordList.add(word);
                    prefixHashTable.put(prefix,wordList);
                }else{
                    wordList.add(word);
                }
            }
        }
    }
    protected static List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = prefixHashTable.get(prefix);
        return (wordList != null ? wordList : new ArrayList<String>());
    }
}
