package Tutorial3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarSearch {

    private State8 initialState;
    private State8 goalState;
    private HashSet<TreeNode<State8>> visitedNodes;
    private ArrayList<State8> path;

    public AStarSearch(Tutorial3.State8 initial, Tutorial3.State8 goal) {
        initialState = initial;
        goalState = goal;
    }

    public void findPath() {
        Tutorial3.TreeNode<Tutorial3.State8> currentState;
        ArrayList<Tutorial3.State8> worldDynamics;

        //Initialise the root node
        TreeNode<State8> root = new TreeNode<State8>(initialState, 0, calculateHeuristic(initialState));

        //Initialise the visited nodes as a list of tree nodes of states. Add the root node.
        visitedNodes = new HashSet<Tutorial3.TreeNode<Tutorial3.State8>>();

        PriorityQueue<TreeNode<State8>> priorityStateQueue = new PriorityQueue<TreeNode<State8>>();
        priorityStateQueue.add(root);

        while(true) {
            currentState = priorityStateQueue.poll();
            visitedNodes.add(currentState);
            if (currentState.getState().equals(goalState)) {
                path = determinePath(currentState);
                return;
            }
            worldDynamics = currentState.getState().getWorldDynamics();
            for (State8 state : worldDynamics) {
                TreeNode<State8> child = new TreeNode<State8>(state, 0, calculateHeuristic(state));
                if (!visitedNodes.contains(child)) {
                    child = currentState.addChild(state, calculateHeuristic(state));
                    priorityStateQueue.add(child);
                }
            }
        }

    }

    private ArrayList<State8> determinePath(TreeNode<State8> endNode) {

        ArrayList<State8> path = new ArrayList<State8>();
        path.add(endNode.getState());
        TreeNode<State8> parent = endNode.getParent();

        while(parent != null) {
            path.add(parent.getState());
            parent = parent.getParent();
        }

        return path;
    }

    private int calculateHeuristic(State8 currentState) {
        int total = 0;
        int distance = 0;
        for(int i = 0; i < 9; i++) {

            char num = currentState.getState().charAt(i);
            int j = goalState.getState().indexOf(num);

            int currentColumn = i % 3;
            int goalColumn = j % 3;
            int currentRow = calcRow(i);
            int goalRow = calcRow(j);

            distance = java.lang.Math.abs(currentColumn - goalColumn) + java.lang.Math.abs(currentRow - goalRow);

            total += distance;

        }
        return total;
    }

    public ArrayList<State8> getPath() {
        return path;
    }

    public HashSet<TreeNode<State8>> getVisitedNodes() {
        return visitedNodes;
    }

    private int calcRow(int i) {
        if (i < 3) {
            return 0;
        } else if (i > 5) {
            return 2;
        } else {
            return 1;
        }
    }
}
