package L류호석.L03_다양한정렬응용.b04Q15970;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//그룹핑을 할때 정렬을 이용하면 좋음.
public class MyQ15970 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static Point[] arr;
    static int answer;

    static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        arr = new Point[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = new Point(sc.nextInt(), sc.nextInt());
        }
    }

    static void func() {
        int sum = arr[1].position - arr[0].position
                + arr[N - 1].position - arr[N - 2].position;

        for (int i = 1; i <= N - 2; ++i) {
            int right = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            if (arr[i - 1].color == arr[i].color) {
                left = arr[i].position - arr[i - 1].position;
            }
            if (arr[i].color == arr[i+1].color) {
                right = arr[i + 1].position - arr[i].position;
            }
            sum += Math.min(left, right);
        }

        answer =sum;
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(arr);
        func();
        System.out.println(answer);

    }

    static class Point implements Comparable<Point> {
        int position;
        int color;

        public Point(int position, int color) {
            this.position = position;
            this.color = color;
        }

        @Override
        public int compareTo(Point o) {
            if (color != o.color) return Integer.compare(color, o.color);
            return Integer.compare(position, o.position);
        }
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
