package arrays;

import java.util.*;

/*
Here sorting makes it O(nlogn) we don't need to sort it. On run itself we can make a variable String currentBestTeam = "" and keep on updating it on every run
 */
public class tournamentWinner {
    public static String tournamentWinnerImpl(List<List<String>> competitions, List<Integer> results) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            List<String> competition = competitions.get(i);
            Integer result = results.get(i);

            if (result == 0) {
                map.put(competition.get(1), map.containsKey(competition.get(1)) ? map.get(competition.get(1)) + 3 : 3);
            } else if (result == 1) {
                map.put(competition.get(0), map.containsKey(competition.get(0)) ? map.get(competition.get(0)) + 3 : 3);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list using a custom Comparator
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                // Sort in ascending order
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        return list.get(0).getKey();
    }

    public static void main(String[] args) {
        List<String> str = List.of("HTML", "C");
        List<String> str2 = List.of("C#", "Python");
        List<String> st3 = List.of("Python", "HTML");
        System.out.println(tournamentWinnerImpl(List.of(str, str2, st3), List.of(0, 0, 1)));
        // 1- Home team 0 -Away team
        // first - hometeam awayteam
    }
}
