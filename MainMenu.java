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

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JFrame frame;
	private JLabel label;
	private String[] sorting = {"Bubble Sort", "Counting Sort", "Heap Sort", "Insertion Sort", "Merge Sort", "Quick Sort",
			"Selection Sort", "Shell Sort" };
	private String sort_name;
	Dimension screen;

	public MainMenu() {
		frame = new JFrame();
		panel = new JPanel();

		panel.setBorder(BorderFactory.createEmptyBorder(100, 400, 100, 400));
		GridLayout layout = new GridLayout(0, 1);
		layout.setVgap(10);
		panel.setLayout(layout);
		panel.setBackground(new Color(207, 254, 212));

		label = new JLabel("Learn Sorting Algorithms");
		label.setFont(label.getFont().deriveFont(36.0f));
		label.setHorizontalAlignment(getX());
		panel.add(label);

		for (int i = 0; i < sorting.length; i++) {
			int chosen = i;
			JButton button = new JButton(sorting[i]);
			button.setBackground(new Color(144, 238, 144));
			button.setFocusPainted(false);
			button.setBorderPainted(false);
			button.addMouseListener(new java.awt.event.MouseAdapter() {
				boolean clicked = false;

				public void mouseEntered(java.awt.event.MouseEvent evt) {
					button.setBackground(new Color(27, 190, 27));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					if (!clicked)
						button.setBackground(new Color(144, 238, 144));
				}

				public void mousePressed(java.awt.event.MouseEvent evt) {
					clicked = true;
					sort_name = sorting[chosen];
					Description description = new Description(sort_name);
					description.setVisible(true);
					frame.setVisible(false);
					frame.dispose();
				}
			});
			panel.add(button);
		}
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.add(panel, BorderLayout.CENTER);
		frame.setBounds(0, 0, screen.width, screen.height - 30);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Sorting Algorithms");
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
