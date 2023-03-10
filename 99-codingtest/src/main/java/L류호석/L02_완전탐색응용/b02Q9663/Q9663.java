package L류호석.L02_완전탐색응용.b02Q9663;

import java.io.*;
import java.util.*;

//체크 배열 없이 그때그때 마다 체크해주기때문에, 중복 체크 고려안해도됨
public class Q9663 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true; //기울기 양수인 대각선
        if (r1 + c1 == r2 + c2) return true; // 기울기 음수인 대각선
        return false;
    }

    //row 부터 N번 까지 가능한 경우의수를 구해줘
    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid check (row, c)
                for (int i=1;i<=row-1;i++){
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])){
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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