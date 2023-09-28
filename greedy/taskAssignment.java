package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class taskAssignment {

    public static ArrayList<ArrayList<Integer>> taskAssignmentImpl(int k, List<Integer> tasks) {

        int end = tasks.size() -1;
        int start = 0;

        ArrayList<Integer> copyObject = new ArrayList<Integer>(tasks);

        copyObject.sort(Integer::compareTo);

        ArrayList<ArrayList<Integer>> response = new ArrayList<ArrayList<Integer>>();
        while (end > start) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(tasks.indexOf(copyObject.get(end)));
            integers.add(tasks.indexOf(copyObject.get(start)));

            tasks.set(tasks.indexOf(copyObject.get(end)), -1);
            tasks.set(tasks.indexOf(copyObject.get(start)), -1);

            response.add(integers);
            start++;
            end--;
        }
        return response;
    }

    public static void main(String[] args) {

        List<Integer> tasks = Arrays.asList(1, 3, 5, 3, 1, 4);

        System.out.println(taskAssignmentImpl(3, tasks));
    }
}
