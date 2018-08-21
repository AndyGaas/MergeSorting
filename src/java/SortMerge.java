package java;

import java.io.File;
import java.io.IOException;

public class SortMerge {
    public static void main(String[] args) throws IOException {
        File fileOne = new File("C:\\Projects\\MergeSorting\\in1.txt");
        File fileTwo = new File("C:\\Projects\\MergeSorting\\in2.txt");
        File fileThree = new File("C:\\Projects\\MergeSorting\\in3.txt");


        // try {
        //     try (BufferedReader bfr = new BufferedReader(new FileReader(fileOne))) {
        //     }
        //     String name = bufferedReader.readLine();
        //     String line;
        // } catch (FileNotFoundException error) {
        //     error.printStackTrace();
        // } finally {
        //     bufferedReader.close();
        // }

        // System.out.println(Arrays.toString(array));
        // mergeSort(array);
        // System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        if (array.length == 1) {
            return;
        }

        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, array);
    }

    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}