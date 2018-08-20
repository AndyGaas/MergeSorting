import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortMerge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File fileOne = new File("C:\\Projects\\MergeSorting\\in1.txt");

        try {
            try (BufferedReader bfr = new BufferedReader(new FileReader(fileOne))) {
            }
            String name = bufferedReader.readLine();
            String line;
        } catch (FileNotFoundException error) {
            System.out.println("Ошибка: " + error);
        } finally {
            bufferedReader.close();
        }

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