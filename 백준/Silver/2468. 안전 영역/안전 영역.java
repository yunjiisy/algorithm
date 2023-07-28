import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] area;
    static int highest = 0;
    static boolean[][] isFlooded;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        isFlooded = new boolean[N][N];
        area = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(isFlooded[i], true);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(highest, area[i][j]);
            }
        }

        int maxCount = 0;
        for (int i = 1; i <= highest; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (area[j][k] >= i && isFlooded[j][k]) {
                        count++;
                        dfs(i, j, k);
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
            resetIsFlooded(); // 각 비에 대한 영역 탐색이 끝난 후 isFlooded 배열을 초기화합니다.
        }

        System.out.println(maxCount);
    }

    private static void dfs(int i, int j, int k) {
        isFlooded[j][k] = false;
        if (j != N - 1 && isFlooded[j + 1][k] && area[j + 1][k] >= i) {
            dfs(i, j + 1, k);
        }
        if (k != N - 1 && isFlooded[j][k + 1] && area[j][k + 1] >= i) {
            dfs(i, j, k + 1);
        }
        if (j > 0 && isFlooded[j - 1][k] && area[j - 1][k] >= i) {
            dfs(i, j - 1, k);
        }
        if (k > 0 && isFlooded[j][k - 1] && area[j][k - 1] >= i) {
            dfs(i, j, k - 1);
        }
    }

    private static void resetIsFlooded() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(isFlooded[i], true);
        }
    }
}
