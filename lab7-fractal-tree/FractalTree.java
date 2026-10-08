import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {
    private final int MAX_DEPTH = 9; // How many times should the tree grow branches

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Start the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH); // Start the recursion
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth != 0) {
            int length = 12 * depth; // length gets smaller by depth

            // x2 and y2 by trigonometry
            double x2 = x1 + length * Math.cos(Math.toRadians(angle));
            double y2 = y1 + length * Math.sin(Math.toRadians(angle));

            g.drawLine(x1, y1, (int) x2, (int)y2); // Draw branch

            // Two recursive calls to add two more branches
            drawTree(g,(int) x2,(int) y2, angle - 20, depth - 1);
            drawTree(g,(int) x2,(int) y2, angle + 30, depth - 1);
        }
    }

    // Create frame for display testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
