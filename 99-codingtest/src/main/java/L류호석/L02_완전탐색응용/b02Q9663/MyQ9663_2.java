package L류호석.L02_완전탐색응용.b02Q9663;

//완전탐색으로 체크없이 일단 다 선택후
//마지막 depth 에서 잘 놓아졌는지 체크 하는방법 -> 시간초과뜸 : 불필요한 탐색을 굉장히 많이함 : 불필요하면 탐색을 시도조차하지말아야함
//체크를 하면서 depth 를 깊게 들어가는방법으로 해야함

//이렇게 하면 중복 check 된것을 unchek 할때 한번에 다 풀기때문에 안됨.... 중복체크도 고려해야됨.
import java.io.*;
import java.util.StringTokenizer;

public class MyQ9663_2 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int cnt;
    static boolean[][] check;

    public static void input() {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        check = new boolean[N][N];
    }

    private static void checking(int selectedRow, int depth) {

        int row = selectedRow;
        int col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row][col++] =true;
        }

        row = selectedRow;
        col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row--][col++] =true;
        }

        row = selectedRow;
        col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row++][col++] =true;
        }
    }

    private static void unchecking(int selectedRow, int depth) {

        int row = selectedRow;
        int col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row][col++] =false;
        }

        row = selectedRow;
        col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row--][col++] =false;
        }

        row = selectedRow;
        col = depth;
        while (row >= 0 && row < N && col < N) {
            check[row++][col++] =false;
        }

    }

    public static void dfs(int depth) {
        if (depth < N) {
            for (int row = 0; row < N; ++row) {
                if (check[row][depth]) continue;

                checking(row, depth);
                dfs(depth + 1);
                unchecking(row, depth);
            }
        } else {
            ++cnt;
        }
    }


    public static void main(String[] args) {

        input();
        dfs(0);
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
