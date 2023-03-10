package L류호석.L01_어떻게든푼다완전탐색.b02Q15649;


import java.io.*;
import java.util.StringTokenizer;

//체크 배열을 안만들어놓고 매 라운드 마다 쓰였는지 안쓰였는지 확인함 (공간복잡도에서는 유리하지만 시간복잡도에서는 불리)
//백준에서 시간초과뜨네
public class Q15649 {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] result;

    public static void input(){

        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        result= new int[M+1];
    }

    public static void rec_func(int k){
        if(k==M+1){
            for(int i=1; i<=M; ++i) sb.append(result[i]).append(' ');
            sb.append(' ');
        }
        else{
            for(int i=1; i<=N; ++i){

                boolean isUsed = false;
                for(int resultIndex=1; resultIndex<k; ++i){
                    if(result[resultIndex]==i){
                        isUsed=true;
                        break;
                    }
                }
                if(isUsed) continue;

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
