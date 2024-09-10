import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DungeonGame {
    private void findSmallestSteps(List<List<Character>> steps, int x, int y, int goldx, int goldy, int row, int col, boolean[][] visited, List<Character> temp) {
        if (x == goldx && y == goldy) {
            steps.add(new ArrayList<>(temp)); // Add a new copy of the current path
            return;
        }

        if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y]) return; // Boundary or visited check

        visited[x][y] = true;

        // Move left
        temp.add('L');
        findSmallestSteps(steps, x - 1, y, goldx, goldy, row, col, visited, temp);
        temp.remove(temp.size() - 1);

        // Move right
        temp.add('R');
        findSmallestSteps(steps, x + 1, y, goldx, goldy, row, col, visited, temp);
        temp.remove(temp.size() - 1);

        // Move up
        temp.add('U');
        findSmallestSteps(steps, x, y + 1, goldx, goldy, row, col, visited, temp);
        temp.remove(temp.size() - 1);

        // Move down
        temp.add('D');
        findSmallestSteps(steps, x, y - 1, goldx, goldy, row, col, visited, temp);
        temp.remove(temp.size() - 1);

        visited[x][y] = false;
    }

    private List<Character> findShortestPath(List<List<Character>> paths) {
        if (paths.isEmpty()) return new ArrayList<>();

        List<Character> shortestPath = paths.get(0);

        for (List<Character> path : paths) {
            if (path.size() < shortestPath.size()) {
                shortestPath = path;
            }
        }
        return shortestPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Dimensions of the dungeon
        int row = sc.nextInt();
        int col = sc.nextInt();

        // Adventurer's coordinates
        System.out.println("Enter adventurer's x coordinate");
        int advX = sc.nextInt();
        advX = row - advX;
        System.out.println("Enter adventurer's y coordinate");
        int advY = sc.nextInt();
        advY = col - advY;

        // Gold coordinates
        System.out.println("Enter gold's x coordinate");
        int goldX = sc.nextInt();
        goldX = row - goldX;
        System.out.println("Enter gold's y coordinate");
        int goldY = sc.nextInt();
        goldY = col - goldY;

        // Monster's coordinates
        System.out.println("Enter monster's x coordinate");
        int monX = sc.nextInt();
        monX = row - monX;
        System.out.println("Enter monster's y coordinate");
        int monY = sc.nextInt();
        monY = col - monY;

        //Trigger's coordinates
        System.out.println("Enter trigger's x coordinate");
        int trigX = sc.nextInt();
        trigX = row - trigX;
        System.out.println("Enter trigger's y coordinate");
        int trigY = sc.nextInt();
        trigY = col - trigY;

        boolean[][] advVisited = new boolean[row][col];

//        //Pits
//        int numberOfPits = sc.nextInt();
//        for(int i=0; i<numberOfPits; i++)   {
//            System.out.println("Enter the x coordinate: ");
//            int x = sc.nextInt();
//
//            System.out.println("Enter the y coordinate: ");
//            int y = sc.nextInt();
//            advVisited[x][y] = true;
//        }

        DungeonGame dg = new DungeonGame();

        // Adventurer's path
        List<List<Character>> advPaths = new ArrayList<>();
        dg.findSmallestSteps(advPaths, advX, advY, goldX, goldY, row, col, advVisited, new ArrayList<>());

        // Monster's path
        boolean[][] monVisited = new boolean[row][col];
        List<List<Character>> monPaths = new ArrayList<>();
        dg.findSmallestSteps(monPaths, monX, monY, goldX, goldY, row, col, monVisited, new ArrayList<>());

        // Shortest Path of both adventurer and monster
        List<Character> advShortestPath = dg.findShortestPath(advPaths);
        List<Character> monShortestPath = dg.findShortestPath(monPaths);

        // Print the result
        if (advShortestPath.size() < monShortestPath.size()) {
            System.out.println("Minimum number of steps: " + advShortestPath.size());
            System.out.println("Path: " + advShortestPath);
        } else {
            //Path to trigger
            boolean[][] triggerVisited = new boolean[row][col];
            List<List<Character>> trigPaths = new ArrayList<>();
            dg.findSmallestSteps(trigPaths, advX, advY, trigX, trigY, row, col, triggerVisited, new ArrayList<>());
            List<Character> trigShortestPath = dg.findShortestPath(trigPaths);

            //Updated coordinates
            advX = trigX;
            advY = trigY;

            advVisited = new boolean[row][col];
            advPaths = new ArrayList<>();
            dg.findSmallestSteps(advPaths, advX, advY, goldX, goldY, row, col, advVisited, new ArrayList<>());
            advShortestPath = dg.findShortestPath(advPaths);

            System.out.println("Minimum number of steps: " + (trigShortestPath.size() + advShortestPath.size()));
        }
    }
}
