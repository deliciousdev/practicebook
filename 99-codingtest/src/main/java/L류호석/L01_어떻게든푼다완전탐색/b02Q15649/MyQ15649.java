package L류호석.L01_어떻게든푼다완전탐색.b02Q15649;

import java.io.*;
import java.util.StringTokenizer;

public class MyQ15649 {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] result;
    static boolean[] isUsed;

    public static void input(){

        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        result= new int[M+1];
        isUsed = new boolean[N+1];
    }

    public static void rec_func(int k){
        if(k==M+1){
            for(int i=1; i<=M; ++i) sb.append(result[i]).append(' ');
            sb.append('\n');
        }
        else{
            for(int i=1; i<=N; ++i){
                if(isUsed[i]) continue;

                isUsed[i]=true;
                result[k]=i;
                rec_func(k+1);
                isUsed[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        input();
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
