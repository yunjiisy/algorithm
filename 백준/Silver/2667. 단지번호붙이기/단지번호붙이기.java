import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());


        int[][] aisle = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄씩 입력 받기
            for (int j = 0; j < N; j++) {
                aisle[i][j] = line.charAt(j) - '0'; // 입력 받은 문자열을 이차원 배열에 저장
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (aisle[i][j] == 1) {
                    int size = dfs(aisle, i, j);
                    a.add(size);
                }
            }
        }

        Collections.sort(a); // 오름차순으로 정렬

        System.out.println(a.size());
        for (int size : a) {
            System.out.println(size);
        }
    }


    static int dfs(int[][] aisle, int i, int j) {
        int size = 1;
        aisle[i][j] = 0;
        if (i + 1 < aisle.length && aisle[i + 1][j]==1)
            size += dfs(aisle, i + 1, j);
        if (j + 1 < aisle.length && aisle[i][j + 1]==1)
            size += dfs(aisle, i, j + 1);
        if (i - 1 >= 0 && aisle[i - 1][j]==1)
            size += dfs(aisle, i - 1, j);
        if (j - 1 >= 0 && aisle[i][j - 1]==1)
            size += dfs(aisle, i, j - 1);
        return size;
    }
}
