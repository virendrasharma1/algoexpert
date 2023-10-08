package stacks;

import java.util.*;
import java.util.stream.Collectors;

public class sunsetViews {

    public static ArrayList<Integer> sunsetViewsImpl(int[] buildings, String direction) {

        ArrayList<Integer> indexList = new ArrayList<>();
        Stack<Integer> buildingStack = new Stack<>();


        if (direction.equals("WEST")) {

            for (int i = 0; i < buildings.length; i++) {
                if (buildingStack.isEmpty()) {
                    buildingStack.add(buildings[i]);
                    indexList.add(i);
                } else {
                    int latest = buildingStack.peek();
                    if (latest < buildings[i]) {
                        buildingStack.add(buildings[i]);
                        indexList.add(i);
                    }
                }
            }
        } else {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildingStack.isEmpty()) {
                    buildingStack.add(buildings[i]);
                    indexList.add(i);
                } else {
                    int latest = buildingStack.peek();
                    if (latest < buildings[i]) {
                        buildingStack.add(buildings[i]);
                        indexList.add(i);
                    }
                }
            }
        }

        if (direction.equals("WEST")) {
            Collections.reverse(indexList);
        }
        return indexList;
    }

    public static void main(String[] args) {
        System.out.println(sunsetViewsImpl(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST"));
        System.out.println(sunsetViewsImpl(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "WEST"));
    }
}
