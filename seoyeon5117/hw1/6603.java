import java.io.*;
import java.util.StringTokenizer;

public class 6603 {
    public static void DFS(BufferedWriter bw, int curr, int N, int M, int[] arr, int[] visited, int[] order) throws IOException{
        if(curr == M){
            for(int i = 0 ; i < M ; i++){
                bw.write(arr[order[i]] + " ");
            }
            bw.newLine();
            return;
        }
        for(int i = 0 ; i < N ; i++){
            if(visited[i] == 1) continue;

            visited[i] = 1; //true
            order[curr] = i;
            DFS(bw, curr+1, N, M, arr, visited, order);
            visited[i] = 0; //false
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] visited = new int[M];
        int[] order = new int[M];

        for(int i = 0; i < N ; i++){
            arr[i] = i + 1;
        }

        DFS(bw, 0, N, M, arr, visited, order);
        bw.close();
    }
}
