package trie;

interface Node {
  public String getValue();
  public boolean containsChildValue(char c);

  public Node getChild(char c);

  public static final Node EMPTY_NODE = new Node() {
    public String getValue() {
      return "";
    }

    public boolean containsChildValue(char c) {
      return false;
    }

    public Node getChild(char c) {
      return this;
    }
  };

}
