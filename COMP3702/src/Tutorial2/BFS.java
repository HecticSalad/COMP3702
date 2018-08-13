package Tutorial2;
import Tutorial2.State8;

import java.util.*;

public class BFS {

    private State8 initialState;
    private State8 goalState;

    public BFS(State8 initial, State8 goal) {
        initialState = initial;
        goalState = goal;

    }

    public ArrayList<State8> findPath() {
        //Define current state as a tree node, and the world dynamics as a list of states
        TreeNode<State8> currentState;
        ArrayList<State8> worldDynamics;

        //Initialise the root node
        TreeNode<State8> root = new TreeNode<State8>(initialState);

        //Initialise the visited nodes as a list of tree nodes of states. Add the root node.
        LinkedList<TreeNode<State8>> visitedNodes = new LinkedList<TreeNode<State8>>();

        //Initialise the queue as a list of tree nodes of states. Add the root.
        LinkedList<TreeNode<State8>> stateQueue = new LinkedList<TreeNode<State8>>();
        stateQueue.add(root);

        //Main loop
        while(true) {

            //Pop off the last item and set it to the current state
            currentState = stateQueue.poll();
            //If this is the goal state, return.
            if (currentState.getState().equals(goalState)) {
                return getPath(currentState);
            }

            //Remove currentState from the queue and add to visited vertices
            visitedNodes.add(currentState);
            worldDynamics = currentState.getState().getWorldDynamics();

            //For each next possible state from world dynamics, if it is not the goal:
            for (State8 state : worldDynamics) {
                TreeNode<State8> child = new TreeNode<State8>(state);
                if (!visitedNodes.contains(child)) {
                    stateQueue.add(child);
                    child = currentState.addChild(state);
                }

            }
        }
    }

    private ArrayList<State8> getPath(TreeNode<State8> endNode) {

        ArrayList<State8> path = new ArrayList<State8>();
        path.add(endNode.getState());
        TreeNode<State8> parent = endNode.getParent();

        while(parent != null) {
            path.add(parent.getState());
            parent = parent.getParent();
        }

        return path;
    }
}
