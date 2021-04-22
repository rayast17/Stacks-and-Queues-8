
import java.awt.Color;

class Ball implements Comparable<Ball> {
	int x = 0;
	int y = 0; // Current ball position
	int dx = 2; // Increment on ball's x-coordinate
	int dy = 2; // Increment on ball's y-coordinate
// int radius = 5; // Ball radius (

	int radius = (int) (Math.random() * 19 + 2);
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

	public int compareTo(Ball arg0) {
		if (radius - arg0.radius > 0) {
			return 1;
		} else if (radius - arg0.radius < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}