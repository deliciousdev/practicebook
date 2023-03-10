package L류호석.L02_완전탐색응용.b03Q1182;

import java.io.*;
import java.util.StringTokenizer;

//입력을 받을때 sort를 해주면 탐색도중, 누적값이 S를 넘고, 데이터가 양수이면 탐색을 안해도됨
//내가 한거 : nC1 + nC2 + nC3 + .... +nCn
// <-> 첫번째를 선택할지 말지 * 두번째를 선택할지 말지 * ...* N번째를 선택할지 말지 =2^N
public class MyQ1182 {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int S;
    static int cnt;
    static int[] arr;
    static int[] result;
    static int x;

    public static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        result = new int[N];
    }

    public static void rec_func(int depth, int select) {
        if (depth < x) {
            for (int i = select + 1; i < N; ++i) {
                result[depth] = i;
                rec_func(depth + 1, i);
            }
        } else {
            int sum = 0;
            for (int i = 0; i < x; ++i) {
                sum += arr[result[i]];
            }
            if (sum == S) ++cnt;
        }
    }

    public static void nCombination(int i) {
        x = i;
        rec_func(0, -1);
    }

    public static void main(String[] args) {

        input();
        for (int i = 1; i <= N; ++i) {
            nCombination(i);
        }

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
