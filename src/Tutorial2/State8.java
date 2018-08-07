package Tutorial2;
import java.util.ArrayList;

public class State8 implements Comparable<State8>{

    private String state;
    private ArrayList<State8> myWorldDynamics;

    public State8(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public State8 moveUp() {
        int space = state.indexOf("_");
        int tile = space - 3;

        if (space < 3) {
            return new State8("");
        }

        return new State8(swap(state, space, tile));
    }

    public State8 moveDown() {

        int space = state.indexOf("_");
        int tile = space + 3;

        if (space > 5) {
            return new State8("");
        }

        return new State8(swap(state, space, tile));
    }

    public State8 moveLeft() {

        int space = state.indexOf("_");
        int tile = space - 1;

        ArrayList<Integer> illegal = new ArrayList<Integer>();
        illegal.add(0);
        illegal.add(3);
        illegal.add(6);

        if(illegal.contains(space)) {
            return new State8("");
        }

        return new State8(swap(state, space, tile));
    }

    public State8 moveRight() {

        int space = state.indexOf("_");
        int tile = space + 1;

        ArrayList<Integer> illegal = new ArrayList<Integer>();
        illegal.add(2);
        illegal.add(5);
        illegal.add(8);

        if(illegal.contains(space)) {
            return new State8("");
        }

        return new State8(swap(state, space, tile));
    }

    public String swap(String string, int a, int b) {

        char[] myCharArray = string.toCharArray();
        char tmp = myCharArray[a];
        myCharArray[a] = myCharArray[b];
        myCharArray[b] = tmp;
        return new String(myCharArray);

    }

    public void displayGrid() {
        if (state.isEmpty()) {
            System.out.println("State does not exist");
            return;
        }
        System.out.println(state.substring(0, 3));
        System.out.println(state.substring(3, 6));
        System.out.println(state.substring(6, 9));
        System.out.print("\n");
    }

    public boolean equals(State8 itemState) {
        return (state.equals(itemState.getState()));
    }

    public int compareTo(State8 item) {
        return state.compareTo(item.getState());
    }

    public ArrayList<State8> getWorldDynamics() {

        ArrayList<State8> worldDynamics = new ArrayList<State8>();

        worldDynamics.add(moveUp());
        worldDynamics.add(moveDown());
        worldDynamics.add(moveRight());
        worldDynamics.add(moveLeft());

        myWorldDynamics = worldDynamics;

        return worldDynamics;

    }

    public void displayWorldDynamics() {
        if (state.isEmpty()) {
            System.out.print("Grid does not exist");
            return;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(String.format("Option %d", i+1));
            myWorldDynamics.get(i).displayGrid();
        }
    }







}

