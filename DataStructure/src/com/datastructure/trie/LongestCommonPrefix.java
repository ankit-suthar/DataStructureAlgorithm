/*
Given a set of strings, find the longest common prefix.

Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"

Insert all the words one by one in the trie. After inserting we perform a walk on the trie.
In this walk, go deeper until we find a node having more than 1 children(branching occurs) or 0 children (one of the string gets exhausted).
This is because the characters (nodes in trie) which are present in the longest common prefix must be the single child of its parent,
i.e- there should not be branching in any of these nodes.
*/
package com.datastructure.trie;

public class LongestCommonPrefix {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode{
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isLeaf;

        public TrieNode(){
            isLeaf = false;
            for(int i = 0; i < ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }

    static TrieNode root;
    static int indexes;

    static void insert(String string){
        int length = string.length();
        int index;
        TrieNode trieNode = root;

        for(int level=0;level<length;level++){
            index = string.charAt(level) - 'a';

            if(trieNode.children[index]==null){
                trieNode.children[index] = new TrieNode();
            }
            trieNode = trieNode.children[index];
        }
        trieNode.isLeaf = true;
    }

    static void constructTrie(String[] arr,int n){
        for(int i=0;i<n;i++){
            insert(arr[i]);
        }
    }

    static int countChildren(TrieNode trieNode){
        int count=0;
        for(int i=0;i<ALPHABET_SIZE;i++){
            if(trieNode.children[i]!=null){
                count++;
                indexes = i;
            }
        }
        return count;
    }

    static String walkTrie(){
        TrieNode trieNode = root;
        indexes = 0;
        String prefix = "";

        while(countChildren(trieNode)==1 && trieNode.isLeaf==false){
            trieNode = trieNode.children[indexes];
            prefix += (char)('a' + indexes);
        }
        return prefix;
    }

    static String commonPrefix(String[] arr,int n){
        root = new TrieNode();
        constructTrie(arr,n);
        return walkTrie();
    }

    public static void main(String[] a){
        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);

        if (ans.length() != 0)
            System.out.println("The longest common prefix is "+ans);
        else
            System.out.println("There is no common prefix");
    }
}
//Time Complexity : Inserting all the words in the trie takes O(MN) time and performing a walk on the trie takes O(M) time, where-
//N = Number of strings
//M = Length of the largest string
//Auxiliary Space: To store all the strings we need to allocate O(26*M*N) ~ O(MN) space for the Trie