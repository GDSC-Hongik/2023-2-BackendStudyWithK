import java.util.Scanner;

public class Main {
    static boolean [] seen = new boolean[9];
    static int [] arr = new int[9];
    static int n = 0, m = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

//        System.out.println(n + " " + m);
        solve(0, m - 1);
    }

    public static void solve(int idx, int max_idx) {
//        System.out.println(idx + " " + max_idx);
//        System.out.println(n + " " + m);

        if(idx == max_idx + 1) {
            for(int i = 0; i <= max_idx; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(seen[i]) continue;

            seen[i] = true;
            arr[idx] = i;

            solve(idx + 1, max_idx);

            arr[idx] = 0;
            seen[i] = false;
        }
        return;
    }
}
