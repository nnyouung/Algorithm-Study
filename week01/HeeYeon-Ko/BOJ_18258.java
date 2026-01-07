import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(); // 시간초과 방지

        while(N>0){
            String command = bf.readLine();
            StringTokenizer st = new StringTokenizer(command);
            // push
            if(st.nextToken().equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }
            // pop
            else if(command.equals("pop")){
                if(!queue.isEmpty()){
                    int num = queue.poll();
                    sb.append(num).append("\n");
                }
                else{
                    sb.append(-1).append("\n");
                }
            }
            // size
            else if(command.equals("size")){
                int num = queue.size();
                sb.append(num).append("\n");
            }
            // empty
            else if(command.equals("empty")){
                if(!queue.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(1).append("\n");
                }
            }
            // front
            else if(command.equals("front")){
                if(!queue.isEmpty()){
                    int num = queue.peek();
                    sb.append(num).append("\n");
                }
                else{
                    sb.append(-1).append("\n");
                }
            }
            // back
            else if(command.equals("back")){
                if(!queue.isEmpty()){
                    int num = queue.getLast();
                    sb.append(num).append("\n");
                }
                else{
                    sb.append(-1).append("\n");
                }
            }
            N--;
        }
        System.out.println(sb);
    }
}
