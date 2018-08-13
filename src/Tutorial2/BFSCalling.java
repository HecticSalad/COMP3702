package Tutorial2;

public class BFSCalling {
    public static void main(String[] args) {
        State8 initial = new State8("1348627_5");
        State8 goal = new State8("1238_4765");

        BFS myBFS = new BFS(initial, goal);
    }
}
