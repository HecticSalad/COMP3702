package Tutorial2;
import Tutorial2.State8;

import java.util.*;

public class BFS {

    private State8 initialState;
    private State8 goalState;
    private LinkedList<TreeNode<State8>> visitedNodes;
    private ArrayList<State8> path;

    public BFS(State8 initial, State8 goal) {
        initialState = initial;
        goalState = goal;

    }

    public void findPath() {
        //Define current state as a tree node, and the world dynamics as a list of states
        TreeNode<State8> currentState;
        ArrayList<State8> worldDynamics;

        //Initialise the root node
        TreeNode<State8> root = new TreeNode<State8>(initialState);

        //Initialise the visited nodes as a list of tree nodes of states. Add the root node.
        visitedNodes = new LinkedList<TreeNode<State8>>();

        //Initialise the queue as a list of tree nodes of states. Add the root.
        LinkedList<TreeNode<State8>> stateQueue = new LinkedList<TreeNode<State8>>();
        stateQueue.add(root);

        //Main loop
        while(true) {

            //Pop off the last item and set it to the current state
            currentState = stateQueue.pop();
            //If this is the goal state, return.
            if (currentState.getState().equals(goalState)) {
                System.out.println("Goal state has been achieved.\n");
                System.out.println("Goal state: " + goalState.toString() + "\n");
                System.out.println("Current state: " + currentState.toString() + "\n");
                path = determinePath(currentState);
                return;
            }

            //Remove currentState from the queue and add to visited vertices
            visitedNodes.add(currentState);
            worldDynamics = currentState.getState().getWorldDynamics();

            //For each next possible state from world dynamics, if it is not the goal:
            for (State8 state : worldDynamics) {
                TreeNode<State8> child = new TreeNode<State8>(state);
                if (!visitedNodes.contains(child)) {
                    child = currentState.addChild(state);
                    stateQueue.addFirst(child);
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

    public LinkedList<TreeNode<State8>> getVisitedNodes() {
        return visitedNodes;
    }

    public ArrayList<State8> getPath() {
        return path;
    }
}
