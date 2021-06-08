package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SortArray extends JPanel {

	private int[] array;
	private int[] color;

	public SortArray(String sorting_name) {
		setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		setLayout(new BorderLayout(10, 10));
		setBackground(new Color(207, 254, 212));
		array = new int[20];
		color = new int[20];

		// Label
		JLabel label = new JLabel(sorting_name);
		label.setBounds(300, 100, 600, 200);
		label.setFont(label.getFont().deriveFont(45.0f));
		label.setHorizontalAlignment(getX());
		label.setVerticalAlignment(SwingConstants.TOP);
		add(label, BorderLayout.NORTH);

		// Buttons

		JButton back_button = new JButton("Go Back");
		back_button.setBackground(new Color(144, 238, 144));
		back_button.setFocusPainted(false);
		back_button.setBorderPainted(false);

		back_button.addMouseListener(new java.awt.event.MouseAdapter() {
			boolean clicked = false;

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				back_button.setBackground(new Color(27, 190, 27));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (!clicked)
					back_button.setBackground(new Color(144, 238, 144));
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				clicked = true;
				Description description = new Description(sorting_name);
				description.setVisible(true);

			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2, 500, 500));
		buttonPanel.setBackground(new Color(207, 254, 212));
		buttonPanel.add(back_button);
		add(back_button, BorderLayout.SOUTH);

		// fill the array with random numbers
		int r = 0;
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			r = rand.nextInt(99);
			array[i] = r;
			color[i] = 0;
		}
		setVisible(true);
	}

	public int getLength() { // return size of the array
		return array.length;
	}

	public int get(int i) { // return element at index i in the array
		return array[i];
	}

	public void swap(int a, int b) {
		color[a] = 100;
		color[b] = 100;
		repaint();
		delay(700);
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		color[a] = 100;
		color[b] = 100;
		repaint();
		delay(1000);
	}

	public void recolor(int i, int v) {
		color[i] = 100;
		repaint();
		delay(1000);
		array[i] = v;
		color[i] = 100;
		repaint();
		delay(1000);
	}

	public void resetColors() {
		for (int i = 0; i < 20; i++) {
			color[i] = 0;
		}
		repaint();
	}

	// Timer method
	public static void delay(long time) {// takes time in milliseconds
		long nanoseconds = time * (long) Math.pow(10, 6);
		long timepassed;
		long startTime = System.nanoTime();
		do {
			timepassed = System.nanoTime() - startTime;
		} while (timepassed < nanoseconds);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		super.paintComponent(graphics);
		graphics.setFont(new Font("", 0, 25));
		graphics.setColor(new Color(0, 0, 0));
		for (int x = 0; x < 20; x++) {
			int xBegin = 200 + 49 * x;
			int yBegin = 300;

			int val = color[x] * 2;
			graphics.setColor(new Color(50 + val, 0, 0));
			graphics.drawRect(xBegin, yBegin, 50, 50);
			graphics.drawString(array[x] + "", xBegin + 10, yBegin + 35);

			if (color[x] > 0) {
				color[x] = 0;
			}
		}
		for (int x = 0; x < 20; x++) {
			int xBegin = 200 + 49 * x;
			int yBegin = 300;
			graphics.setFont(new Font("", 0, 15));
			graphics.drawString(x + "", xBegin + 15, yBegin - 10);
		}
	}
}
