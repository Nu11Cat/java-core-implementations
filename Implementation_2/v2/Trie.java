class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(char i : word.toCharArray()) {
            int index = i - 'a';
            if(node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;  //单词路径存在，并且该节点是单词的结尾
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;    //存在单词路径
    }

    // 查找 Trie 中是否存在给定前缀。
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for(char i : prefix.toCharArray()) {
            int index = i - 'a';
            if(node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */