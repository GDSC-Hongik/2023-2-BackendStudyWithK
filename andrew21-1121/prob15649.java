package shillahotel;

import java.util.Scanner;

public class prob15649 {

    static int[] numArr;
    static boolean[] visited;

    public static void printPermutation(int n, int depthToGo) {
        if (depthToGo == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.println(" " + (i + 1));
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                visited[i] = true;
                printPermutation(n, depthToGo - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        numArr = new int[n];
        visited = new boolean[n];

        printPermutation(n,m-1);
    }
}
