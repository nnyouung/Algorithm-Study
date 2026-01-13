/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2346                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2346                           #+#        #+#      #+#    */
/*   Solved: 2026/01/13 06:39:37 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.*;
import java.util.*;

public class Main{

    // 풍선 객체 
    static class Balloon{
        int index;
        int next;

        Balloon(int index, int next) {
            this.index = index;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException{

        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 준비
        StringBuilder sb = new StringBuilder();

        // 자료구조 - deque 사용
        Deque<Balloon> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 풍선 객체 만들어서 덱에 삽입
        for (int i = 1; i <= N; i++) {
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while(!deque.isEmpty()){
            Balloon cur = deque.pollFirst();
            sb.append(cur.index).append(" ");

            if(deque.isEmpty()) break; // 마지막 풍선 객체를 뽑고 나면 종이 안봐도 됨. 아니 못봄.

            if(cur.next > 0){ // 종이에 적힌 숫자
                for (int i = 0; i < cur.next - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                cur.next *= -1;
                for (int i = 0; i < cur.next; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);

    }
}