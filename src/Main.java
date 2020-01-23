import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intLists1 = Arrays.asList(1, 2);
        List<Integer> intLists2 = Arrays.asList(9, 8, 7);

         List<Pair<Integer, Integer>> returnInt = zip(intLists1, intLists2);

        for (Pair<Integer, Integer> i : returnInt
             ) {
            System.out.println("[" + i.getValue() + "," + i.getWord() + "]");
        }


    }

    public static List<Pair<Integer, Integer>> zip(List<Integer> lists1, List<Integer> lists2) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        for (int i = 0; i < lists1.size() && i < lists2.size(); i++) {
            Pair<Integer, Integer> pairs = new Pair<>(lists1.get(i), lists2.get(i));
            result.add(pairs);
        }

        return result;

    }
}
