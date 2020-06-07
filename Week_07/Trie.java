/**
 * 208. 实现 Trie (前缀树)
 * 向 Trie 树中插入键
 * 时间复杂度：O(m)，其中 m 为键长。在算法的每次迭代中，我们要么检查要么创建一个节点，直到到达键尾。只需要 m 次操作。
 * 空间复杂度：O(m)。最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。此时需要添加 m 个结点，使用 O(m) 空间。
 * 在 Trie 树中查找键
 * 时间复杂度 : O(m)。算法的每一步均搜索下一个键字符。最坏的情况下需要 m 次操作。
 * 空间复杂度 : O(1)。
 * 查找 Trie 树中的键前缀
 * 时间复杂度 : O(m)。
 * 空间复杂度 : O(1)。
 */
public class Trie {

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    private boolean is_string = false;
    private Trie next[] = new Trie[26];

    public void insert(String word) {//插入单词
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
            root = root.next[w[i] - 'a'];
        }
        root.is_string = true;
    }

    public boolean search(String word) {//查找单词
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) return false;
            root = root.next[w[i] - 'a'];
        }
        return root.is_string;
    }

    public boolean startsWith(String prefix) {//查找前缀
        Trie root = this;
        char p[] = prefix.toCharArray();
        for (int i = 0; i < p.length; ++i) {
            if (root.next[p[i] - 'a'] == null) return false;
            root = root.next[p[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */