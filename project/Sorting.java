package project;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

public class Sorting extends JFrame {
	private Dimension screen;
	private final SortArray sortArray;
	boolean swapped;
	String sort_name;

	public Sorting(String sorting_name) {
		sort_name = sorting_name;
		sortArray = new SortArray(sorting_name);
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(sortArray);
		setTitle(sorting_name + " Visualization");
		pack();
		setVisible(true);
	}

	public void runSort() {
		SortArray.delay(2000);
		switch (sort_name) {
		case "Bubble Sort":
			bubbleSort(sortArray);
			break;
		case "Counting Sort":
			countSort(sortArray);
			break;
		case "Heap Sort":
			heapSort(sortArray);
			break;
		case "Insertion Sort":
			insertionSort(sortArray);
			break;
		case "Merge Sort":
			mergeSort(sortArray, 0, sortArray.getLength() - 1);
			break;
		case "Quick Sort":
			quickSort(sortArray, 0, sortArray.getLength() - 1);
			break;
		case "Selection Sort":
			selectionSort(sortArray, 0, sortArray.getLength());
			break;
		case "Shell Sort":
			shellSort(sortArray);
			break;
		}
		sortArray.resetColors();
	}

	// Sorting Algorithms

	// Bubble sort

	public void bubbleSort(SortArray a) {
		int length = a.getLength();
		for (int i = 0; i < length - 1; i++) {
			swapped = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (a.get(j) > a.get(j + 1)) {
					a.swap(j, j + 1);
					swapped = true;
				}
			}
			if (swapped = false)
				return;
		}
	}

	// Insertion sort

	public void insertionSort(SortArray a) {
		for (int i = 0; i < a.getLength(); i++) {
			int key = a.get(i);
			int j = i - 1;
			while (j >= 0 && a.get(j) > key) {
				a.recolor(j + 1, a.get(j));
				j--;
			}
			a.recolor(j + 1, key);
		}
	}

	// Quick sort

	public void quickSort(SortArray a, int s, int e) {
		int i = s, j = e;
		if (s >= e)
			return;
		int pivot = a.get((s + e) / 2);
		while (i <= j) {
			while (a.get(i) < pivot)
				i++;
			while (a.get(j) > pivot)
				j--;
			if (i <= j) {
				a.swap(i, j);
				i++;
				j--;
			}
		}
		quickSort(a, s, j);
		quickSort(a, i, e);
	}

	// Selection sort

	public void selectionSort(SortArray a, int s, int e) {
		for (int i = s; i < e; i++) {
			int min = i;
			for (int j = i + 1; j < e; j++) {
				if (a.get(j) < a.get(min)) {
					min = j;
				}
			}
			a.swap(i, min);
		}
	}

	// Merge sort

	public void merge(SortArray array, int s, int m, int e) {
		int s1 = m - s + 1;
		int s2 = e - m;

		int left[] = new int[s1];
		for (int i = 0; i < s1; i++) {
			left[i] = array.get(s + i);
		}
		int right[] = new int[s2];
		for (int i = 0; i < s2; i++) {
			right[i] = array.get(m + 1 + i);
		}

		int i = 0, j = 0, k = s;
		while (i < s1 && j < s2) {
			if (left[i] <= right[j]) {
				array.recolor(k, left[i]);
				i++;
			} else {
				array.recolor(k, right[j]);
				j++;
			}
			k++;
		}
		while (i < s1) {
			array.recolor(k, left[i]);
			i++;
			k++;
		}
		while (j < s2) {
			array.recolor(k, right[j]);
			j++;
			k++;
		}
	}

	public void mergeSort(SortArray array, int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mergeSort(array, s, m);
			mergeSort(array, m + 1, e);
			merge(array, s, m, e);
		}
	}

	// Shell sort

	public int shellSort(SortArray a) {
		int n = a.getLength();
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = a.get(i);
				int j;
				for (j = i; j >= gap && a.get(j - gap) > temp; j -= gap)
					a.recolor(j, a.get(j - gap));
				a.recolor(j, temp);
			}
		}
		return 0;
	}

	// Counting sort

	public void countSort(SortArray a) {
		int max = 0;
		for (int i = 0; i < a.getLength(); i++) {
			if (a.get(i) > max)
				max = a.get(i);
		}
		int[] out = new int[a.getLength()];
		int[] count = new int[max + 1];
		for (int i = 0; i < out.length; ++i) {
			out[i] = a.get(i);
			a.recolor(i, out[i]);
			++count[a.get(i)];
		}
		for (int i = 1; i < count.length; ++i)
			count[i] += count[i - 1];
		for (int i = out.length - 1; i > -1; --i)
			a.recolor(--count[out[i]], out[i]);
	}

	// Heap sort

	public void heapSort(SortArray a) {
		int n = a.getLength();
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(a, n, i);
		for (int i = n - 1; i > 0; i--) {
			a.swap(0, i);
			heapify(a, i, 0);
		}
	}

	void heapify(SortArray a, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && a.get(l) > a.get(largest))
			largest = l;

		if (r < n && a.get(r) > a.get(largest))
			largest = r;

		if (largest != i) {
			a.swap(i, largest);
			heapify(a, n, largest);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sorting algorithm name: ");
		String sort = scan.nextLine();
		Sorting sorting = new Sorting(sort);
		sorting.runSort();
	}
}
