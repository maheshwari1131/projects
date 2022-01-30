package com.design;

import sun.text.normalizer.Trie;

public class TrieImpl {
    private TrieNode root;

    public TrieImpl(){
        root=new TrieNode();

    }

    public void insert(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char curchar=word.charAt(i);
            if(!node.containsKey(curchar)){
                node.put(curchar,new TrieNode());
            }
            node=node.get(curchar);
        }
        node.setEnd();
    }
    private TrieNode searchPrefix(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));

            }else{
                return null;
            }
        }
        return node;
    }
    //returns true if word is in the trie;
    public boolean search(String word){
        TrieNode node=searchPrefix(word);
        return node!=null&& node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node=searchPrefix(prefix);
        return node!=null;
    }
}
