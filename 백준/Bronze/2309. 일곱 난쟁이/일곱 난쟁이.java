import java.util.Scanner;

public class Main { //TODO
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        search:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - heights[i] - heights[j] == 100) {
                    heights[j] = 0;
                    heights[i] = 0;
                    break search;
                }
            }
        }

        bubbleSort(heights);
        for (int i : heights) {
            if (i != 0) System.out.println(i);
        }
        sc.close();
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}