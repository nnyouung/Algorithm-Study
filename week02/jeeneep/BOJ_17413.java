package week02.jeeneep;

import java.io.*;
import java.util.*;


public class BOJ_17413 {

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        ArrayDeque<Character> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        for (int i = 0; i < line.length(); i++) {

            char current = line.charAt(i);

            if (current == '<') {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                }
                sb.append('<');
                isTag = true;
            }
            else if (current == '>') {
                sb.append('>');
                isTag = false;
            } 
            else if (isTag) {
                sb.append(current); 
            } 
            else {
                if (current == ' ') {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                    }
                    sb.append(' ');
                } else {
                    deque.offerFirst(current);
                }
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        System.out.println(sb);
    }
}
