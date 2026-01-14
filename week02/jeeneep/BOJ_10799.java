package week02.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        int resultSum = 0;
        for (int i = 0; i < line.length(); i++) {
            
            char current = line.charAt(i);

            // '(' 일 떄
            if (current == '(') {
                stack.offerFirst(current);
            }
            // ')' 일 때
            else {
                // 레이저일 때
                if (line.charAt(i - 1) == '(') {
                    stack.pollFirst();
                    resultSum += stack.size();
                }
                // 쇠막대의 끝일 때
                else {
                    stack.pollFirst();
                    resultSum ++;
                }
            }
        }
        System.out.println(resultSum);
    }
}

