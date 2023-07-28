import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main
{
    static int M, N, K;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    visited[j][k] = true;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int size = dfs(j, i);
                    if (size > 0) {
                        result.add(size);
                        count++;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Collections.sort(result);
        bw.write(count + "\n");
        for (int number : result) {
            bw.write(number + " ");
        }
        bw.flush();
        bw.close();
    }

    static int dfs(int x, int y) {
        if (y < 0 || y >= M || x < 0 || x >= N || visited[y][x]) {
            return 0;
        }

        visited[y][x] = true;
        int size = 1;

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            size += dfs(nx, ny);
        }

        return size;
    }
}
