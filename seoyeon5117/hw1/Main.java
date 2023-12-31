import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void DFS(BufferedWriter bw, int curr, int cnt, int[] arr, int N, int[] order) throws IOException{
        if(curr == 6){
            for(int i = 0 ; i < 6 ; i ++){
                bw.write(arr[order[i]] + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = cnt ; i < N; i++){
            order[curr] = i;
            DFS(bw, curr+1, i+1, arr, N, order);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());
        while(k!=0){
            int[] arr = new int[k];
            int[] order = new int[k];
            for(int i = 0 ; i < k ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            DFS(bw, 0, 0, arr, k, order);
            bw.newLine();
            st = new StringTokenizer(bf.readLine());
            k = Integer.parseInt(st.nextToken());
        }
        bw.close();
    }
}

