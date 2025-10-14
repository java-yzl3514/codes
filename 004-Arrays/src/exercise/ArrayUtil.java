package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ArrayUtil {

    /*
        Mock Data generation
     */
    public static int[] generateRandomIntArray(final int length) {
        return generateRandomIntArray(length, 0, 1000);
    }

    public static int[] generateRandomIntArray(final int length, int origin, int bound) {
        return generateRandomIntArray(new java.util.Random(), length, origin, bound);
    }

    public static int[][] generateRandomMatrix(int row, int column, int origin, int bound) {
        java.util.Random random = new java.util.Random();
        int[][] matrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                matrix[r][c] = random.nextInt(origin, bound);
            }
        }
        return matrix;
    }

    public static int[] generateRandomIntArray(java.util.Random random, final int length, int origin, int bound) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++)
            arr[i] = random.nextInt(origin, bound);
        return arr;
    }

    public static void evenBeforeOddSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentValue = arr[i];
            if (isEvenV2(currentValue)) {
                // continue
            } else {
                int oddIndex = i + 1;
                while (oddIndex < arr.length && isOddV2(arr[oddIndex])) {
                    oddIndex++;
                }
                if (oddIndex < arr.length) {
                    arr[i] = arr[oddIndex];
                    arr[oddIndex] = currentValue;
                } else {
                    break;
                }
            }
        }

    }

    public static void eventBeforeOddSortV2(int[] arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;
        while (evenIndex < oddIndex) {
            int currentValue = arr[evenIndex];
            if (isEvenV2(currentValue)) {
                evenIndex++;
            } else {
                swap(arr, evenIndex, oddIndex);
                oddIndex--;
            }
        }
    }

    /*
       Bu metot ile daha az sayıda swap işlemi yapılması hedeflendi.
       Lütfen eventBeforeOddSortV2 metodu ile karşılaştırınız ve algoritmaları yeniden açıklayınız.

     */
    public static void eventBeforeOddSortV2Optimized(int[] arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;
        while (evenIndex < oddIndex) {
            while (evenIndex < arr.length && isEvenV2(arr[evenIndex])) {
                evenIndex++;
            }
            while (oddIndex >= 0 && isOddV2(arr[oddIndex])) {
                oddIndex--;
            }

            if (evenIndex < oddIndex) {
                swap(arr, evenIndex, oddIndex);
                evenIndex++;
                oddIndex--;
            }
        }
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        // TODO: check for index legality
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    public static boolean isOddV2(int value) {
        return (value & 1) == 1;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isEvenV2(int value) {
        return (value & 1) == 0;
    }


    public static void bubbleSort(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSortV2(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            for (int i = 0; i < arr.length - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void bubbleSortV3(int[] arr) {
        boolean isSorted = false;
        for (int k = 1; k < arr.length && !isSorted; k++) {
            isSorted = true;
            for (int i = 0; i < arr.length - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }


    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertionElement = arr[i];
            int k = i - 1;
            while (k >= 0 && arr[k] > insertionElement) {
                arr[k + 1] = arr[k--];
            }
            arr[k + 1] = insertionElement;
        }
    }

    public static void selectionSortMinVersion(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }
            swap(arr, i, currentMinIndex);
        }
    }


    public static void quickSort(int[] arr){
        quickSort(arr,0, arr.length - 1);
    }

    public static void quickSort(int[] arr,int firstIndex, int lastIndex){
        if(firstIndex >= lastIndex) return;
        int pivotIndex = partition(arr, firstIndex, lastIndex);
        quickSort(arr, firstIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex  + 1, lastIndex);
    }

    public static int partition(int[] arr,int firstIndex, int lastIndex) {
        int pivot = arr[firstIndex];
        int low = firstIndex + 1;
        int high = lastIndex;

        while(low < high){
            while(low <= high && arr[low] <= pivot){
                low++;
            }
            while(low <= high && arr[high] > pivot){
                high--;
            }
            if(low < high){
                swap(arr, low, high);
            }
        }

        while(high > firstIndex && arr[high] >= pivot){
            high--;
        }

        if(pivot > arr[high]){
            swap(arr, firstIndex, high);
            return high;
        }

        return firstIndex;
    }


    //--------------- PRINT METHODS ---------------------------
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printV2(int[] arr) {
        java.lang.StringBuilder builder = new java.lang.StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i < arr.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        System.out.println(builder);
    }


    public static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1)
                    System.out.print(", ");
            }
            System.out.print("]");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    //--------------- END OF PRINT METHODS ---------------------------


}
