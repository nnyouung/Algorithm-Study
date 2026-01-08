import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            if(command.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("pop_front")){
                if(!deque.isEmpty()){
                    int num = deque.removeFirst();
                    sb.append(num).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            }
            else if(command.equals("pop_back")){
                if(!deque.isEmpty()){
                    int num = deque.removeLast();
                    sb.append(num).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            }
            else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(!deque.isEmpty()){
                    sb.append(0).append("\n");
                } else{
                    sb.append(1).append("\n");
                }
            }
            else if(command.equals("front")){
                if(!deque.isEmpty()){
                    int num = deque.getFirst();
                    sb.append(num).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            }
            else if(command.equals("back")){
                if(!deque.isEmpty()){
                    int num = deque.getLast();
                    sb.append(num).append("\n");
                } else{
                    sb.append(-1).append("\n");
                }
            }

        }

        System.out.println(sb);

    }
}
