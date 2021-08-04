import java.util.Scanner;

public class Q1{
    static int n;

    static void mergeArrays(int arr1[], int arr2[], int n1,
                            int n2, int arr3[]) {
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < n1)
            arr3[k++] = arr1[i++];

        while (j < n2)
            arr3[k++] = arr2[j++];
    }


    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    static void mergeKArrays(int arr[][], int i, int j, int output[]) {

        if (i == j) {
            for (int p = 0; p < n; p++) {
//                System.out.println(arr.length +"  "+i);
                output[p] = arr[i][p];
            }
            return;
        }


        if (j - i == 1) {
            mergeArrays(arr[i], arr[j], n, n, output);
            return;
        }


        int[] out1 = new int[n * (((i + j) / 2) - i + 1)];
        int[] out2 = new int[n * (j - ((i + j) / 2))];


        mergeKArrays(arr, i, (i + j) / 2, out1);
        mergeKArrays(arr, (i + j) / 2 + 1, j, out2);

        mergeArrays(out1, out2, n * (((i + j) / 2) - i + 1), n * (j - ((i + j) / 2)), output);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int k = scanner.nextInt();
        int arr[][] = new int[k][n];
        int[] output = new int[n * k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }


        mergeKArrays(arr, 0, k-1, output);
        printArray(output, n * k);
    }
}

