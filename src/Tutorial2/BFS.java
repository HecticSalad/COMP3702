package Tutorial2;
import Tutorial2.State8;

import java.util.*;

public class BFS {

    public ArrayList<State8> BFS(State8 initialState, State8 goalState) {

        TreeNode<State8> currentState;
        ArrayList<State8> worldDynamics;

        TreeNode<State8> root = new TreeNode<State8>(initialState);

        LinkedList<TreeNode<State8>> visitedNodes = new LinkedList<TreeNode<State8>>();
        visitedNodes.add(root);

        LinkedList<TreeNode<State8>> stateQueue = new LinkedList<TreeNode<State8>>();
        stateQueue.add(root);

        while(true) {
            currentState = stateQueue.poll();
            if (currentState.getState().equals(goalState)) {
                return getPath(currentState);
            }

            //Remove currentState from the queue and add to visited vertices
            visitedNodes.add(currentState);
            worldDynamics = currentState.getState().getWorldDynamics();

            //For each next possible state from world dynamics, if it is not the goal:
            for (State8 state : worldDynamics) {
                TreeNode<State8> child = currentState.addChild(state);
                if (!visitedNodes.contains(child)) {
                    stateQueue.add(child);
                }

            }
        }
    }

    public ArrayList<State8> getPath(TreeNode endNode) {
        return null;
    }
}
