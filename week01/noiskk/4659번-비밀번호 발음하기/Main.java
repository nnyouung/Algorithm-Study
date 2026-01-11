/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4659                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: zionzion00 <boj.kr/u/zionzion00>            +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4659                           #+#        #+#      #+#    */
/*   Solved: 2026/01/10 20:53:34 by zionzion00    ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        String pwd = br.readLine();

        while (!pwd.equals("end")) {

            int vowelCnt = 0;
            int consonantCnt = 0;
            boolean hasVowel = false;
            boolean isAcceptable = true;

            for (int i = 0; i < pwd.length(); i++) {
                char cur = pwd.charAt(i);

                if (vowelSet.contains(cur)) {
                    hasVowel = true;
                    vowelCnt++;
                    consonantCnt = 0;
                } else {
                    consonantCnt++;
                    vowelCnt = 0;
                }

                // 모음 or 자음 3연속
                if (vowelCnt >= 3 || consonantCnt >= 3) {
                    isAcceptable = false;
                    break;
                }

                // 같은 문자 연속 검사
                if (i > 0 && cur == pwd.charAt(i - 1)) {
                    if (cur != 'e' && cur != 'o') {
                        isAcceptable = false;
                        break;
                    }
                }
            }

            // 모음 하나도 없는 경우
            if (!hasVowel) {
                isAcceptable = false;
            }

            if (isAcceptable) {
                System.out.println("<" + pwd + "> is acceptable.");
            } else {
                System.out.println("<" + pwd + "> is not acceptable.");
            }

            pwd = br.readLine();
        }
    }
}