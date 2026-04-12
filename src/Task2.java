import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }

        int q = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<q;i++){
            String op = sc.nextLine();
            if(op.equals("Insert")){
                int x = sc.nextInt();
                int y = sc.nextInt();
                list.add(x, y);
                sc.nextLine();
            } else if(op.equals("Delete")){
                int x = sc.nextInt();
                list.remove(x);
                sc.nextLine();
            }
        }

        for(int i : list){
            System.out.print(i + " ");
        }
    }
}
