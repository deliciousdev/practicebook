package L류호석.L04_이분탐색.b01Q7795;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 정렬이 보장 되어있을때 이분 탐색 : O(N)
 * x 이하의 원소중에서 가장 오른쪽에 있는 인덱스인 result 를 계속 갱신해나가는 알고리즘
 * arr[result] 는 x이하중 제일 큰값, arr[result+1] 은 x보다 큼.
 * x이하의 숫자는 result+1개 있음 (0부터인덱스가시작일때)
 */

public class MyQ7795 {

    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();

    static int T, N, M, answer;
    static int[] A = new int[20000];
    static int[] B = new int[20000];


    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; ++i) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; ++i) {
            B[i] = sc.nextInt();
        }
    }

    static int binarySearch(int a) {

       int left= 0;
       int right= M-1;
       int mid=0;
       int result=0;
       while(left<=right){
           mid=(left+right)/2;

           if(a>B[mid]){
               left=mid+1;
               result= mid+1;
           }
           else if(a<B[mid]){
               right=mid-1;
           }
           else{
               result=mid;
               break;
           }
       }

        return result;
    }

    static void process() {
        for(int i=0; i<N; ++i){
            answer+=binarySearch(A[i]);
        }
    }

    public static void main(String[] args) {
        T = sc.nextInt();

        for (int i = 0; i < T; ++i) {
            answer = 0;
            input();
            Arrays.sort(B, 0, M);
            process();
            System.out.print(answer+"\n");
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
