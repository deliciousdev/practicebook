package L류호석.L03_다양한정렬응용.b03Q11652;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//hash map 이용 : 최소~최대 범위가 아주큰 엔트리에서는 카운팅할때 Map이 유리함.
public class MyQ11652_2 {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static long l;
    static HashMap<Long, Integer> map = new HashMap<>();
    static long result;
    static void input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();
        for(int i=0; i<N; ++i){
            l = sc.nextLong();

//            if(map.containsKey(l)){
//                map.put(l,map.get(l)+1);
//            }
//            else{
//                map.put(l,1);
//            }
            map.put(l, map.getOrDefault(l,0)+1);//주석과 같은 로직
        }
    }

    static void counting(){
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            long number = entry.getKey();
            if(cnt>max){
                max= cnt;
                result=number;
            }
            else if(cnt==max){
                result= Math.min(result,number);
            }
        }
    }

    static void check(){
        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        input();
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
