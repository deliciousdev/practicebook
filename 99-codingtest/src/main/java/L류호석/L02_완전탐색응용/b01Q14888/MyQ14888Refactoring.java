package L류호석.L02_완전탐색응용.b01Q14888;

import java.io.*;
import java.util.StringTokenizer;

public class MyQ14888Refactoring {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    //    static int result_mx = -2147000000;
//    static int result_mn = 2147000000;
    static int result_mx = Integer.MIN_VALUE;
    static int result_mn = Integer.MAX_VALUE;

    public static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; ++i) {
            operator[i] = sc.nextInt();
        }
    }

    public static void dfs(int depth, int accumulate) {
        if (depth <= N - 1) {

            for(int i=0; i<4; ++i){
                if(operator[i]<1) continue;

                int newAccumulate = calcNewAccumulate(accumulate,i,depth);
                --operator[i];
                dfs(depth + 1, newAccumulate);
                ++operator[i];
            }

        } else {
            if (accumulate > result_mx) result_mx = accumulate;
            if (accumulate < result_mn) result_mn = accumulate;
        }

    }

    private static int calcNewAccumulate(int accumulate, int i, int depth) {
       switch (i){
           case 0:
               return accumulate + arr[depth];
           case 1:
               return accumulate - arr[depth];
           case 2:
               return accumulate * arr[depth];
           default:
               return accumulate / arr[depth];
       }
    }

    public static void main(String[] args) {

        input();
        dfs(1, arr[0]);
        sb.append(result_mx).append('\n').append(result_mn);
        System.out.println(sb.toString());

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
