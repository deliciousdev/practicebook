package L류호석.L01_어떻게든푼다완전탐색.b04Q15650;

import java.io.*;
import java.util.StringTokenizer;

//파라미터로 무엇을 선택했는지 넘겨주기
public class MyQ15650 {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] result;

    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        result= new int[M+1];
//        result[0]=0;
    }

    static void rec_func(int k, int select){
        if( k==M+1){
            for(int i=1 ; i<=M; ++i)sb.append(result[i]).append(' ');
            sb.append('\n');
            return ;
        }

        for(int i=select+1; i<=N; ++i){
            result[k]=i;
            rec_func(k+1,i);
        }
    }

    public static void main(String[] args) {

        input();
        rec_func(1, 0);
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
