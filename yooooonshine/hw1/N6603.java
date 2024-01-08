package January_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N6603 {
    private final int GAME_OVER_NUMBER = 0;
    private final int NUMBER_OF_VALUE_TO_BE_EQUAL = 6;

    public void func() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean checkValue = true;
        while (checkValue) {
            String[] inputList = br.readLine().split(" ");
            int k = Integer.parseInt(inputList[0]);

            if (k == GAME_OVER_NUMBER) {
                checkValue = false;
            }

            if (k != GAME_OVER_NUMBER) {
                int[] lottoCandidateNumbers = Arrays
                        .stream(Arrays.copyOfRange(inputList, 1, inputList.length))
                        .mapToInt(i -> Integer.parseInt(i))
                        .sorted()
                        .toArray();

                boolean[] visited = new boolean[k];
                combination(
                        lottoCandidateNumbers,
                        visited,
                        0,
                        k,
                        NUMBER_OF_VALUE_TO_BE_EQUAL);
            }
        }
    }

    private void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void print(int[] arr,boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("");
    }
}
