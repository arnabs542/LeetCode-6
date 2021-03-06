package debugLaicode;

import java.util.*;


/*

solution:
steps:
1.for each word, find the words that it can change to
time O( k * 26) = O(k)    n = wordlist size   k is word length

2. start from begin word, run breadth first search, to find the shortest path to end word
time O(V + E) = O(n * k)

-----------
total time O(n*K)
total space O(n)

*/
public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        return bfs(beginWord, endWord, set);
    }
    // run BFS algorithm, to find the shortest path from begin word to end word
    private int bfs(String beginWord, String endWord, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int level = 0;
        q.offer(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++){
                // expand
                String curr = q.poll();
                if (curr.equals(endWord)) return level + 1;

                // generate
                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    for (int j = 0; j < 26; j++) {
                        arr[i] = (char)('a'+j);
                        String next = new String(arr);
                        if (set.contains(next)) {
                            if (!visited.contains(next)) {
                                visited.add(next);
                                q.offer(next);
                            }
                        }
                    }
                    arr[i] = c;
                }
            }
            level++;
        }
        return 0;

    }

    public static void main(String[] args) {
        WordLadder1 wordLadder1 = new WordLadder1();

    }
}