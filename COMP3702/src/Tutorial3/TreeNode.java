package Tutorial3;

import java.util.ArrayList;

public class TreeNode<T> implements Comparable<TreeNode<T>>{

    private T state;
    private TreeNode<T> parent;
    private ArrayList<TreeNode> children;
    private int cost;
    private int heuristic;

    public TreeNode(T item, int cost, int heuristic) {
        state = item;
        children = new ArrayList<TreeNode>();
        this.cost = cost;
        this.heuristic = heuristic;
    }

    public TreeNode<T> addChild(T item, int heuristic){
        TreeNode<T> currentChild = new TreeNode<T>(item,this.cost + 1, heuristic);

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

    public int getCost() {
        return cost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public int compareTo(TreeNode<T> item) {
        int itemTotal = item.getCost() + item.getHeuristic();
        int myTotal = getCost() + getHeuristic();

        if (itemTotal > myTotal) {
            return -1;
        } else if (itemTotal < myTotal) {
            return 1;
        } else {
            return 0;
        }
    }

}
