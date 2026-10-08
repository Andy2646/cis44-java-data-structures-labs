public class MazeSolver {
    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     * It should find the starting 'S' position and initiate the recursive search.
     * @return true if a path is found, false otherwise.
     */
    public boolean solve() {
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean solve(int row, int col) {
        // 1. Base Case (Stopping Conditions)
        if (row < 0 || row > maze.length || col < 0 || col > maze[0].length) { // If row and col is out of bounds
            return false;
        }
        else if (maze[row][col] == '#' || maze[row][col] == '.') { // If the cell is out of bounds, a wall, or already visited.
            return false;
        }
        else if (maze[row][col] == 'F') { // If the current cell is the finish ('F')
            return true;
        }

        // 2. Recursive Step
        maze[row][col] = '.'; // Mark the current cell as part of the path

        // If any direction returns true, then you've found a path, return true.
        if (solve(row - 1, col) || // North
                solve(row, col + 1) || // East
                solve(row + 1, col) || // South
                solve(row, col - 1)) // West
        {
            return true;
        }

        // 3. Backtracking
        // If no direction works, un-mark the cell and return false.
        maze[row][col] = ' ';
        return false;
    }

    public static void main(String[] args) {
        // Mazes
        char[][] maze1 = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        char[][] maze2 = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', '#', '#', '#'},
                {'#', ' ', '#', ' ', ' ', '#', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        // Solvers
        MazeSolver solver1 = new MazeSolver(maze1);
        MazeSolver solver2 = new MazeSolver(maze2);

        // Maze 1
        System.out.println("Original Maz1:");
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver1.printMaze();

        // Maze 2
        System.out.println("Original Maz2:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver2.printMaze();
    }
}
