package Tutorial3;

public class AStarSearchCalling {

    public static void main(String[] args) {

        State8 initial = new State8("123_45678");
        State8 goal = new State8("12345678_");

        AStarSearch A = new AStarSearch(initial, goal);
        A.findPath();
        System.out.println(A.getPath());
        System.out.println(A.getPath().size());
        System.out.println(A.getVisitedNodes().size());

    }
}
