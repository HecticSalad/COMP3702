package Tutorial2;
import java.util.*;

public class SearchTree<T> {

    Node root;
    Node cursor;

    public SearchTree(T rootNode) {
        root = new Node(rootNode);
    }

    public ArrayList<T> getPath() {
        return null;
    }

    public Node newNode(T item){
        return new Node(item);
    }

    public void addChild(T child, T parent) {
        //Remember to move the cursor
    }

    public class Node {

        T item;
        T[] children;

        private Node(T contents) {
            item = contents;
        }

    }

}


