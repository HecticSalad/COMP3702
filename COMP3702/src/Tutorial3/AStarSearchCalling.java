package Tutorial3;

public class AStarSearchCalling {

    public static void main(String[] args) {

        State8 initial = new State8("281463_75");
        State8 goal = new State8("1238_4765");

        AStarSearch A = new AStarSearch(initial, goal);
        A.findPath();
        System.out.println(A.getPath());
        System.out.println(A.getPath().size());
        System.out.println(A.getVisitedNodes().size());

    }
}
