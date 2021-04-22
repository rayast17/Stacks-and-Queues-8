
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
// private ArrayList<Ball> list = new ArrayList<Ball>();

	private PriorityQueue<Ball> queue = new PriorityQueue<Ball>(Collections.reverseOrder());

// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
// for (int j = 0; j < list.size(); j++) {
// Ball ball = (Ball) list.get(j);
				for (Ball ball : queue) {

					double distance = BallPanel.distance(x, y, ball.x, ball.y);
					if (ball.radius >= distance) {
// list.remove(ball); 

						queue.remove(ball);
						break;
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub

			}

		});
	}

	public void add() {
// list.add(new Ball());
		queue.offer(new Ball());
		System.out.println("Queue ");
		for (Ball ball : queue) {
			System.out.println(ball.radius);
		}

	}

	public void subtract() {
// if (list.size() > 0)
// list.remove(list.size() - 1); // Remove the last ball

		if (queue.size() > 0) {
			queue.poll();
			System.out.println("Queue ");
		}
		for (Ball ball : queue) {
			System.out.println(ball.radius);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Ball ball : queue) {
// for (int i = 0; i < list.size(); i++) {
// Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
// Check boundaries

			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;

// Adjust ball position

			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);

		}
		ArrayList<Ball> ballsToRemove = new ArrayList<>();
// for (int i = 0; i < list.size(); i++) { 
// Ball ball1 = (Ball) list.get(i); // Get a ball
		for (Ball ball1 : queue) {
			if (ballsToRemove.contains(ball1) == false) {
// for (int j = i + 1; j < list.size(); j++) { 

// Ball ball2 = (Ball) list.get(j); // Get a second ball

				for (Ball ball2 : queue) {
					if (ball2 != ball1) {
						int radiusSum = ball1.radius + ball2.radius;
						double distance = BallPanel.distance(ball1.x, ball1.y, ball2.x, ball2.y);
						if (radiusSum >= distance) {
							ballsToRemove.add(ball2);
							ball1.radius += ball2.radius;
						}
					}
				}
			}
		}
// list.removeAll(ballsToRemove); 
// ballsToRemove
		queue.removeAll(ballsToRemove);
	}

	public static double distance(int x1, int y1, int x2, int y2) {

		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}
