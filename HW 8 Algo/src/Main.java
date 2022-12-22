import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main {

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static int[] selectionsort(int[] sortieren) {
		for (int i = 0; i < sortieren.length - 1; i++) {
			for (int j = i + 1; j < sortieren.length; j++) {
				if (sortieren[i] > sortieren[j]) {
					int temp = sortieren[i];
					sortieren[i] = sortieren[j];
					sortieren[j] = temp;
				}
			}
		}
		return sortieren;
	}
	
	
	
	public static void quickSort(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSort(arr, begin, partitionIndex-1);
	        quickSort(arr, partitionIndex+1, end);
	    }
	}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}

	public static void main(String[] args) {
		
		int[] array_sizes = {50, 100, 500, 1000, 1500, 2000, 2500, 3000, 5000, 7500, 10000};
		
		double[] s_times = new double[array_sizes.length];
		double[] q_times = new double[array_sizes.length];
		
		Random random = new Random();
		
	
			
		for (int i = 0; i <= array_sizes.length-1; i++) {
			int[] array = new int[array_sizes[i]];
			for (int j = 0; j <= array_sizes[i]-1; j++) {
				array[j] = (random.nextInt()) % 1000;
			}
			
			double startTime = System.nanoTime();
			selectionsort(array);
			double endTime = System.nanoTime();
			s_times[i] = ((endTime - startTime) / 1000000000);	
			
		}
			
		for (int i = 0; i <= array_sizes.length-1; i++) {
			int[] array = new int[array_sizes[i]];
			for (int j = 0; j <= array_sizes[i]-1; j++) {
				array[j] = (random.nextInt()) % 1000;
			}
			
			double startTime = System.nanoTime();
			quickSort(array, 0, array.length - 1);
			double endTime = System.nanoTime();
			q_times[i] = ((endTime - startTime) / 1000000000);	
			}
		
		System.out.println("Selectionsort: in Sekunden");
		for (int i = 0; i <= s_times.length-1; i++) {
			System.out.print(s_times[i]);
			System.out.print(", ");
		}
		System.out.println("");
		System.out.println("Quicksort: in Sekunden");
		for (int i = 0; i <= q_times.length-1; i++) {
			System.out.print(q_times[i]);
			System.out.print(", ");
		}
		
	}
	
	}


