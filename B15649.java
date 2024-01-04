import java.util.Scanner;

public class B15649 {
    static int N, M;
    static int[] list;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new int[M + 1];
        visit = new boolean[N + 1];

        recursion(0);
    }

    public static void recursion(int index){
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list[index] = i;
                recursion(index + 1);
                visit[i] = false;
            }
        }
    }
}