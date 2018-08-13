package Tutorial2;

import java.util.LinkedList;
import java.util.ArrayList;

public class BFSCalling {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        State8 initial = new State8("281463_75");
        State8 goal = new State8("1238_4765");

        BFS myBFS = new BFS(initial, goal);
        myBFS.findPath();
        LinkedList<TreeNode<State8>> visitedNodes = myBFS.getVisitedNodes();
        System.out.println(visitedNodes.size());
//        for (State8 state : myBFS.getPath()) {
//            state.displayGrid();
//        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
    }
}
