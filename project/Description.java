package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Description extends JFrame {

	private JPanel panel;
	private JLabel label, description;
	private Dimension screen;
	private JButton demo_button;
	String sort_name;
	boolean run = false;

	public Description(String sorting_name) {
		sort_name = sorting_name;
		label = new JLabel(sorting_name);
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));
		panel.setLayout(new BorderLayout(10, 10));
		panel.setBackground(new Color(207, 254, 212));
		label.setFont(label.getFont().deriveFont(40.0f));
		label.setHorizontalAlignment(getX());
		label.setVerticalAlignment(SwingConstants.TOP);

		description = new JLabel("");

		description.setFont(label.getFont().deriveFont(20.0f));
		description.setText("<html><em><u>Description:<u></em> Bubble Sort works by examining each set of"
				+ " adjacent elements in the string, from left to right, switching their positions if they are out of order. "
				+ "The algorithm then repeats this process until it can run through the entire string and find no "
				+ "two elements that need to be swapped. At each pass, the next largest element bubbles to its proper place."
				+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>). "
				+ "<br>Best Case: O(N), when the input list is already sorted."
				+ "<br><br><em><u>Space Complexity:</u></em> O(1)</html>");
		switch (sorting_name) {
		case "Bubble Sort":
			description.setText("<html><em><u>Description:<u></em> Bubble Sort works by examining each set of"
					+ " adjacent elements in the string, from left to right, switching their positions if they are out of order. "
					+ "The algorithm then repeats this process until it can run through the entire string and find no "
					+ "two elements that need to be swapped. At each pass, the next largest element bubbles to its proper place."
					+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>). "
					+ "<br>Best Case: O(N), when the input list is already sorted."
					+ "<br><br><em><u>Space Complexity:</u></em> O(1)</html>");
			break;
		case "Counting Sort":
			description.setText("<html><em><u>Description:<u></em> Counting sort is a sorting technique based on "
					+ "keys between a specific range. It works by counting the number of objects having distinct "
					+ "key values, then doing some arithmetic to calculate the position of each element"
					+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N+k) where k: range of input. "
					+ "<br>Best Case: O(N+k)" + "<br><br><em><u>Space Complexity:</u></em> O(N+k)</html>");
			break;
		case "Heap Sort":
			description.setText("<html><em><u>Description:<u></em> Heap sort relies on the properties of"
					+ " a heap data structure to sort a data set. Heapsort sorts an array by first converting "
					+ "the array into a heap so that it has the relational property described above. "
					+ "It then sorts the data in reverse by repeatedly placing the largest unsorted element "
					+ "into its correct place. It does so by repeatedly (1) removing the maximum value in the "
					+ "heap (the value in the root node), (2) putting that value into the sorted array, and "
					+ "(3) rebuilding the heap with one fewer elements."
					+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N*logN). "
					+ "<br>Best Case: O(N*logN) (where k is the number of buckets)."
					+ "<br><br><em><u>Space Complexity:</u></em> O(1), it is an inplace sorting algorithm</html>");
			break;
		case "Insertion Sort":
			description.setText("<html><em><u>Description:<u></em> This method is the one that we use to sort "
					+ "playing cards by inserting each card into its proper position."
					+ "<br>How it works: 1. Compare the first 2 elements, swap if needed."
					+ "<br>2. Go to the element at index 2, insert it where it belongs between the first two elements."
					+ "<br>3. Go to the element at index 3, insert it where it belongs among the first three elements."
					+ "<br>4. Continue until the entire array is sorted."
					+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>), when the array is in reverse order. "
					+ "<br>Best Case: O(N), when the array is already sorted."
					+ "<br><br><em><u>Space Complexity:</u></em> O(1), it is an inplace sorting algorithm</html>");
			break;
		case "Merge Sort":
			description
					.setText("<html><em><u>Description:<u></em> Merge Sort is a divide-and-conquer sorting algorithm."
							+ "<br>It works as follow:<br>" + "1. Divide the array into two halves."
							+ "<br>2. Recursively sorts each half." + "<br>3. Merge the 2 sorted halves."
							+ "<br><br><em><u>Running Time:</u></em> Worst case: O(Nlog(N))."
							+ "<br>Best Case: O(N*logN)." + "<br><br><em><u>Space Complexity:</u></em> O(N).</html>");
			break;
		case "Quick Sort":
			description
					.setText("<html><em><u>Description:<u></em> Quick Sort is a divide-and-conquer sorting algorithm. "
							+ "It works by selecting a 'pivot' element from the array and partitioning the other "
							+ "elements into two sub-arrays, according to whether they are less than or greater than the pivot."
							+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>), very rare."
							+ "<br>Average and Best Case: O(N*logN)."
							+ "<br><br><em><u>Space Complexity:</u></em> O(N).</html>");
			break;
		case "Selection Sort":
			description.setText(
					"<html><em><u>Description:<u></em> Selection Sort works by repeatedly selecting the smallest remaining element"
							+ "and placing it in the proper position. "
							+ "It works as follow:<br>1. Find the smallest element. <br>2. Exchange it with the element in the first position."
							+ "<br>3. Find the second smallest element and exchange it with the element in the second position."
							+ "<br>4. Continue this way until the entire array is sorted."
							+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>)."
							+ "<br>Best Case: O(N<sup>2</sup>)."
							+ "<br><br><em><u>Space Complexity:</u></em> O(1).</html>");
			break;
		case "Shell Sort":
			description.setText(
					"<html><em><u>Description:<u></em> Shell Sort starts by sorting pairs of elements far apart "
							+ "from each other, then progressively reducing the gap between elements to be compared. "
							+ "It works as follow:<br>1. Initialize the value of h\r\n"
							+ "Step 2. Divide the list into smaller sub-list of equal interval h\r\n"
							+ "Step 3. Sort these sub-lists using insertion sort\r\n"
							+ "Step 4. Repeat until complete list is sorted"
							+ "<br><br><em><u>Running Time:</u></em> Worst case: O(N<sup>2</sup>), depends on gap sequence."
							+ "<br>Best Case: O(N)." + "<br><br><em><u>Space Complexity:</u></em> O(1).</html>");
			break;
		}

		demo_button = new JButton("Show Demo");
		demo_button.setBackground(new Color(144, 238, 144));
		demo_button.setFocusPainted(false);
		demo_button.setBorderPainted(false);

		demo_button.addMouseListener(new java.awt.event.MouseAdapter() {
			boolean clicked = false;

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				demo_button.setBackground(new Color(27, 190, 27));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				if (!clicked)
					demo_button.setBackground(new Color(144, 238, 144));
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				clicked = true;
				Sorting sorting = new Sorting(sorting_name);
				sorting.setVisible(true);
				sorting.runSort();
			}
		});

		JButton back_button = new JButton("Go Back to Main Menu");
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
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 2, 200, 0));
		buttonPanel.setBackground(new Color(207, 254, 212));
		buttonPanel.add(back_button);
		buttonPanel.add(demo_button);

		panel.add(label, BorderLayout.NORTH);
		panel.add(description, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(sorting_name + " Description");
		setContentPane(panel);
	}
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Description frame = new Description("Sort Name");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
