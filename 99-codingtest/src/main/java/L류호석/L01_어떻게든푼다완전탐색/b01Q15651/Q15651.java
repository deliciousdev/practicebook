package L류호석.L01_어떻게든푼다완전탐색.b01Q15651;

import java.io.*;
import java.util.StringTokenizer;



//귀납적 접근
public class Q15651{

    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static int N,M;
    static int[] selected;

    static void rec_func(int k) { //K번째부터 M번째까지 해줘

        if (k == M + 1) {
            for (int i = 1; i <= M; ++i) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {//나는 k번째를 골를게 너는 k번째부터 M까지 해줘
            for(int i=1; i<=N; ++i){
                selected[k]=i;
                rec_func(k+1);
            }
        }

    }

    public static void main(String[] args) {
        input();

        //1번째부터 M번째까지 해줘
        rec_func(1);
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
