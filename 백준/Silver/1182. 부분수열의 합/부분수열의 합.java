import java.util.Scanner;

public class Main {
    static int N;
    static int S;
    static int cnt;
    static int[] arr;

    public static void dfs(int index, int sum, int depth) {
//        System.out.println( "dfs() 시작:"+index+" depth:"+depth +" index,depth +1해줌  sum:"+sum);

        if (sum == S && depth!=0) {
            cnt++;
//            System.out.println("같음"+sum);
        } else if (depth == N) {
            return;
        }

        for (int i = index; i < N; i++) {
            dfs(i + 1, sum + arr[i], depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0, 0);
        System.out.println(cnt);

        sc.close();
    }
}
