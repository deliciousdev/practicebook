package L류호석.L02_완전탐색응용.b01Q14888;

import java.io.*;
import java.util.StringTokenizer;

//누적값을 배열에 저장하면서 해도되고, 파라미터로 해도됨  : dfs개념으로 접근

//혹은 누적값을 계산하면서 하지않고, 각 단계에서 어떤 operator를 선택할지만 배열에 저장한다음에 마지막 단계에서 한번에 게산해줘도됨
// 순열느낌으로 접근 : 순열의 경우의수를 구한다음에 마지막단계에서 게산해줌: 귀납법 느낌.. : 중간에 누적값을 구하지 않으므로 좋지못함 ㅋ
//마지막에 for문으로 계산을하기 때문에 퍼포먼스 적으로도 불리함

public class MyQ14888 {

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

            if(operator[0]>0){
                --operator[0];
                dfs(depth+1, accumulate+arr[depth]);
                ++operator[0];
            }

            if(operator[1]>0){
                --operator[1];
                dfs(depth+1, accumulate-arr[depth]);
                ++operator[1];
            }

            if(operator[2]>0){
                --operator[2];
                dfs(depth+1, accumulate*arr[depth]);
                ++operator[2];
            }

            if(operator[3]>0){
                --operator[3];
                dfs(depth+1, accumulate/arr[depth]);
                ++operator[3];
            }

        } else {
            if (accumulate > result_mx) result_mx = accumulate;
            if (accumulate < result_mn) result_mn = accumulate;
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
