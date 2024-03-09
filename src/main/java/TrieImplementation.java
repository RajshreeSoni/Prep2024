import java.util.LinkedList;

public class TrieImplementation {
    static class TrieNode {
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList;

        public TrieNode(char c) {
            childList = new LinkedList<TrieNode>();
            isEnd = false;
            content = c;
            count = 0;
        }

        public TrieNode subNode(char c) {
            if (childList != null) {
                for(TrieNode eachChild: childList) {
                    if (eachChild.content == c) {
                        return eachChild;
                    }
                }
            }
            return null;
        }
    }

    static class Trie {
        private static TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            if (search(word)) return;

            TrieNode current = root;
            for (char ch: word.toCharArray()) {
                TrieNode child = current.subNode(ch);
                if (child != null) {
                    current = child;
                } else {
                    current.childList.add(new TrieNode(ch));
                    current = current.subNode(ch);
                }
                current.count++;
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char ch:word.toCharArray()) {
                if (current.subNode(ch) == null) return false;
                else current = current.subNode(ch);
            }
            if (current.isEnd) {
                return true;
            }
            return false;
        }

        public void remove(String word) {
            if (!search(word)) {
                System.out.println(word + "doesn't exist in trie");
                return;
            }
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                TrieNode child = current.subNode(ch);
                if (child.count == 1) {
                    current.childList.remove(child);
                    return;
                } else {
                    child.count--;
                    current = child;
                }
            }
            current.isEnd = false;
        }

        public static String getMatchingPrefix(String word) {
            String result = "";
            int level, prevMatch =0;
            TrieNode current = root;
            for (level = 0;level < word.length(); level++) {
                char ch = word.charAt(level);
                if (current.subNode(ch) != null) {
                    result += ch;
                    current = current.subNode(ch);
                    if (current.isEnd) {
                        prevMatch = level+1;
                    }
                } else {
                    break;
                }
            }
            if (!current.isEnd) {
                return result.substring(0, prevMatch);
            }
            return result;
        }

        public static void main(String args[]) {
            Trie trie = new Trie();
            trie.insert("are");
            trie.insert("area");
            trie.insert("base");
            trie.insert("cat");
            trie.insert("cater");
            trie.insert("basement");

            String input = "caterer";
            System.out.print(input+ ":  ");
            System.out.println(getMatchingPrefix(input));

            input = "basement";
            System.out.print(input + ":   ");
            System.out.println(getMatchingPrefix(input));

            input = "are";
            System.out.print(input + ":   ");
            System.out.println(getMatchingPrefix(input));

            input = "arex";
            System.out.print(input + ":   ");
            System.out.println(getMatchingPrefix(input));

            input = "basemexz";
            System.out.print(input + ":   ");
            System.out.println(getMatchingPrefix(input));

            input = "xyz";
            System.out.print(input + ":   ");
            System.out.println(getMatchingPrefix(input));
        }
    }
}
