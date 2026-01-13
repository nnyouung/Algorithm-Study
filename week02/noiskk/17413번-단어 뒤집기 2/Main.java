/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17413                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17413                          #+#        #+#      #+#    */
/*   Solved: 2026/01/13 07:00:56 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

// import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        
        // 입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 출력 준비
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        // 문자열 입력 받기
        String str = br.readLine();

        boolean isTag = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                case '<': // 태그 시작
                    isTag = true;
                    result.append(word.reverse()).append(c); // 이전까지의 결과를 뒤집기
                    word.setLength(0);
                    break;
                case '>': // 태그 끝
                    result.append(word).append(c); // 태그 속 문자는 뒤집지 않기
                    word.setLength(0);
                    isTag = false;
                    break;
                case ' ':
                    if(!isTag){ // 태그가 아닌 공백 기준으로 뒤집기
                        result.append(word.reverse()).append(c);
                        word.setLength(0);
                    } else {    // 태그 속 공백은 그대로 입력
                        word.append(c);
                    }   break;
                default:
                    word.append(c);
                    break;
            }

            // 마지막 문자가 태그가 아닐 시
            if(i == str.length() - 1 && c != '>'){
                result.append(word.reverse());
            }
           
        }
        
        System.out.println(result);

    }
}


