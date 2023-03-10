package L류호석.L01_어떻게든푼다완전탐색.b03Q15652;

import java.io.*;
import java.util.StringTokenizer;


//전단계에서 무엇을 선택했는지 파라미터로 넘겨주지않고 result를 look up 해서찾음
public class Q15652 {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] result;

    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        result= new int[M+1];
        result[0]=1;
    }

    static void rec_func(int k){
        if(k==M+1){
            for(int i=1; i<=M; ++i) sb.append(result[i]).append(' ');
            sb.append('\n');
        }
        else{
            for(int i=result[k-1]; i<=N; ++i){
                result[k]=i;
                rec_func(k+1);
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
