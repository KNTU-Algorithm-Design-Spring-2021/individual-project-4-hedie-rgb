import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        // Let us create a graph shown in the above example
        int graph[][] = {{0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        int s = 0;
        int t = 7;
        Algorithm.setV(8);
        int n = Algorithm.findDisjointPaths(graph, s, t);
        if (n>=2) {
            System.out.print("The max flow is equal to or bigger than 2 so there can be found two edge-disjoint path");
        } else {
            System.out.print("This is not possible");
        }
    }
}
