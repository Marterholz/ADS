import java.util.Scanner;

public class Main {

    // merge
    static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < arr.length; i++) right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // task 1
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        sortChars(a);
        sortChars(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static void sortChars(char[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;

        char[] left = new char[mid];
        char[] right = new char[arr.length - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < arr.length; i++) right[i - mid] = arr[i];

        sortChars(left);
        sortChars(right);
        mergeChars(arr, left, right);
    }

    static void mergeChars(char[] arr, char[] left, char[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // task 2
    static int findKth(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            System.out.println("Invalid k");
            return -1;
        }
        mergeSort(arr);
        return arr[k - 1];
    }

    // task 3
    static int getMedian(int[] arr) {
        mergeSort(arr);
        int n = arr.length;

        if (n % 2 == 1) return arr[n / 2];
        return (arr[n / 2 - 1] + arr[n / 2]) / 2;
    }

    // task 4
    static int minCapacity(int[] weights, int days) {
        int left = getMax(weights);
        int right = getSum(weights);

        while (left < right) {
            int mid = (left + right) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean canShip(int[] weights, int days, int cap) {
        int usedDays = 1;
        int cur = 0;

        for (int w : weights) {
            if (cur + w > cap) {
                usedDays++;
                cur = 0;
            }
            cur += w;
        }

        return usedDays <= days;
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int x : arr) if (x > max) max = x;
        return max;
    }

    static int getSum(int[] arr) {
        int sum = 0;
        for (int x : arr) sum += x;
        return sum;
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose task:");
        System.out.println("1 - Anagram");
        System.out.println("2 - K-th smallest");
        System.out.println("3 - Median");
        System.out.println("4 - Shipping capacity");

        int task = sc.nextInt();

        if (task == 1) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(isAnagram(s1, s2) ? "YES" : "NO");
        }

        else if (task == 2) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int k = sc.nextInt();
            System.out.println(findKth(arr, k));
        }

        else if (task == 3) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(getMedian(arr));
        }

        else if (task == 4) {
            int n = sc.nextInt();
            int[] weights = new int[n];

            for (int i = 0; i < n; i++) weights[i] = sc.nextInt();

            int days = sc.nextInt();
            System.out.println(minCapacity(weights, days));
        }

        else {
            System.out.println("Wrong choice");
        }

        sc.close();
    }
}