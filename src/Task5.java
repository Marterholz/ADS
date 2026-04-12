import java.util.*;
public class Task5 {
    public static int countStudents(int[] students, int[] samsas){
        int count = 0;
        int i = 0;
        while(i < samsas.length){
            if(students[0] == samsas[i]){
                students = Arrays.copyOfRange(students, 1, students.length);
                i++;
                count = 0;
            } else {
                int first = students[0];
                students = Arrays.copyOfRange(students, 1, students.length);
                students = Arrays.copyOf(students, students.length+1);
                students[students.length-1] = first;
                count++;
                if(count == students.length) break;
            }
        }
        return students.length;
    }

    public static void main(String[] args){
        int[] students = {1,1,0,0};
        int[] samsas = {0,1,0,1};
        System.out.println(countStudents(students, samsas));
    }
}
