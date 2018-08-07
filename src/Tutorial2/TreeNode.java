package Tutorial2;
import java.util.*;

public class TreeNode<T> implements Comparable<TreeNode<T>>{

    private T state;
    private TreeNode<T> parent;
    private ArrayList<TreeNode> children;

    public TreeNode(T item) {
        state = item;
    }

    public TreeNode<T> addChild(T item){
        TreeNode<T> currentChild = new TreeNode<T>(item);

        currentChild.setParent(this);
        children.add(currentChild);

        return currentChild;
    }

    public ArrayList<TreeNode> getChildren(){
        return children;
    }

    public T getState(){
        return state;
    }

    public void setParent(TreeNode<T> thisParent) {
        parent = thisParent;
    }

    public int compareTo(TreeNode<T> item) {
        return this.compareTo(item);
    }

}
