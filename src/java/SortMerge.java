package java;

import java.io.*;

public class SortMerge {
    public static void main(String[] args) {
        // System.out.println(exists("C:\\Projects\\MergeSorting\\src\\resources\\out.txt"));
        // mergeSort(array);
        // System.out.println(Arrays.toString(array));
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        exists(fileName);

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Projects\\MergeSorting\\src\\resources\\in1.txt"));
            try {
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                }
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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