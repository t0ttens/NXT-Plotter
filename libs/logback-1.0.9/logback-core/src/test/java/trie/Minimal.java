package trie;


public class Minimal {



  public Node findValue(Node startNode, String value) {
    Node current = startNode;
    for (char c : value.toCharArray()) {
      if (current.containsChildValue(c)) {
        current = current.getChild(c);
      } else {
        current = Node.EMPTY_NODE;
        break;
      }
    }
    return current;
  }
}
