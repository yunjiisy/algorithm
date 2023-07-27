import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        boolean[][] aisle = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            aisle[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }
        int biggest = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (aisle[i][j])
                    biggest = Math.max(biggest, dfs(aisle, i, j));
            }
        }
        System.out.println(biggest);


    }

    static int dfs(boolean[][] aisle, int i, int j) {
        int size = 1;
        aisle[i][j] = false;
        if (i + 1 < aisle.length && aisle[i + 1][j])
            size += dfs(aisle, i + 1, j);
        if (j + 1 < aisle[0].length && aisle[i][j + 1])
            size += dfs(aisle, i, j + 1);
        if (i - 1 >= 1 && aisle[i - 1][j])
            size += dfs(aisle, i - 1, j);
        if (j - 1 >= 1 && aisle[i][j - 1])
            size += dfs(aisle, i, j - 1);
        return size;
    }
}
