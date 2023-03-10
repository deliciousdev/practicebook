package L류호석.L03_다양한정렬응용.b03Q11652;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MyQ11652 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static Long[] arr;
    static long result;

    static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        arr = new Long[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextLong();
        }
    }

    static void counting() {
        int previous = 0;
        int max = Integer.MIN_VALUE;
        int cnt;
        for (int i = 1; i < arr.length; ++i) {
            if (!arr[i - 1].equals(arr[i])) {
                cnt = i - previous;
                if (cnt >= max) {
                    max = cnt;
                    result=arr[i-1];
                }
                previous = i;
            }
        }

        cnt= arr.length-previous;
        if(cnt>=max){
            max= cnt;
            result=arr[arr.length-1];
        }
    }

    public static void main(String[] args) {
        input();
//        Arrays.sort(arr, (l1, l2) -> Long.compare(l2, l1));
        Arrays.sort(arr, 0, N, (l1, l2) -> Long.compare(l2, l1));
        counting();
        System.out.println(result);
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
