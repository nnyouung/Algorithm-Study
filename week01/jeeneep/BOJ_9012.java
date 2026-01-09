package jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String strT = br.readLine();
        int T = Integer.parseInt(strT);

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int flag = 1; // 0이면 NO, 1이면 YES

            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.offerFirst('(');
                } else {
                    if (stack.isEmpty()) {
                        flag = 0;
                        break;
                    } else {
                        stack.pollFirst();
                    }
                }
            } 
            if (stack.isEmpty() && flag == 1) sb.append("YES").append('\n');
            else sb.append("NO").append('\n'); 
        }
        System.out.println(sb);
    }
   
}
