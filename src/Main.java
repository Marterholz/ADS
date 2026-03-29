import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // task 1
        System.out.print("enter n for sum of squares: ");
        int n1 = in.nextInt();
        System.out.println(sumsquares(n1));

        // task 2
        System.out.print("\n size of array: ");
        int size = in.nextInt();
        int[] arr = new int[size];
        System.out.println("type " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("sum of array: " + sumArray(arr, size));

        // task3
        System.out.print("\ninput b and n: ");
        int b = in.nextInt();
        int n3 = in.nextInt();
        System.out.println("sum of powers: " + sumPowers(b, n3));

        System.out.print("\n input n: ");
        int n4 = in.nextInt();
        System.out.println("input " + n4 + " numbers:");
        reverseInput(in, n4);
    }

   // Task 1 complexity o(n) because it's works n times,which makes it linear dependent
    public static int sumsquares(int n) {
        if (n == 1) return 1;
        return (n * n) + sumsquares(n - 1);
    }

    //task 2 is also o(n) since it's works n times,linear dependent
    public static int sumArray(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + sumArray(arr, n - 1);
    }

   //task 3 and again it's o(n) cause it's works n times
    public static int sumPowers(int b, int n) {
        if (n == 0) return 1; // b^0 = 1
        return (int)Math.pow(b, n) + sumPowers(b, n - 1);
    }

    // task 4 complexity is o(n), it's also calls n times
    public static void reverseInput(Scanner sc, int n) {
        if (n <= 0) {
            return;
        }
        int current = sc.nextInt();
        reverseInput(sc, n - 1);
        System.out.print(current + " ");
    }

}