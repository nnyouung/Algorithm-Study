import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Deque<Balloon> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int paperNum = Integer.parseInt(st.nextToken());
            queue.add(new Balloon(i, paperNum)); // 뒤쪽에 추가
        }

        Balloon balloon = queue.removeFirst(); // 1번 풍선
        sb.append(balloon.balloonNum + 1).append(" ");

        while(!queue.isEmpty()){
            if(balloon.paperNum > 0){ // 양수
                for (int i = 0; i < balloon.paperNum-1; i++) {
                    queue.add(queue.removeFirst());
                }
                balloon = queue.removeFirst();
                sb.append(balloon.balloonNum + 1).append(" ");
            }
            else{ // 음수
                for (int i = 0; i < Math.abs(balloon.paperNum)-1; i++) {
                    queue.addFirst(queue.removeLast());
                }
                balloon = queue.removeLast();
                sb.append(balloon.balloonNum + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    static class Balloon{
        int balloonNum; // 풍선 번호
        int paperNum; // 종이숫자

        Balloon(int i, int n){
            this.balloonNum = i;
            this.paperNum = n;
        }
    }

}
