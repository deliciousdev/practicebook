package L류호석.L02_완전탐색응용.b03Q1182;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


//문제에서 양수의 길이라는것을 놓치면 안됨...(진부분수열 : 공집합 제외)
public class MyQ1182_2 {
    static StringBuilder sb = new StringBuilder();


    static int N, S, cnt;
    static int[] arr;

    public static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) ++cnt;
            return;
        }

        if(!(sum>=S && arr[depth]>0)) {
            dfs(depth + 1, sum + arr[depth]);
        }
        dfs(depth + 1, sum);

    }

    public static void main(String[] args) {
        input();
        if (S == 0) --cnt;
        dfs(0, 0);
        System.out.println(cnt);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
