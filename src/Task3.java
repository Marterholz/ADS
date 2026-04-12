import java.util.*;
public class Task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<n;i++){
            int type = sc.nextInt();
            if(type==1){
                dq.addFirst(sc.nextInt());
            } else if(type==2){
                dq.addLast(sc.nextInt());
            } else if(type==3){
                System.out.print(dq.removeFirst() + " ");
            } else if(type==4){
                System.out.print(dq.removeLast() + " ");
            }
        }
    }
}
