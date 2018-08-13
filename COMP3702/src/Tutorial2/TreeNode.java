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

    public TreeNode<T> getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object item) {
        boolean retVal = false;

        if (item instanceof TreeNode) {
            TreeNode<T> v = (TreeNode<T>) item;
            retVal = v.getState().equals(state);
        }

        return retVal;
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return state.toString();
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
