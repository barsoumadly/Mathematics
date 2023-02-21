import java.util.ArrayList;
import java.util.Scanner;

public class PracticeJava {
    public static void main(String[] args) {
        Pair<ArrayList<Integer>, ArrayList<Integer>> pair = createSet();
        showMenuOptions();
        performFunction(chooseFunction(), pair);
    }

    public static ArrayList<Integer> getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of set");
        int size = scanner.nextInt();
        System.out.println("Enter element of set");
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            set.add(scanner.nextInt());
        }
        return set;
    }

    public static Pair<ArrayList<Integer>, ArrayList<Integer>> createSet() {
        return new Pair<>(getData(), getData());
    }

    public static void showMenuOptions() {
        System.out.println("U: Union");
        System.out.println("I: Intersection");
        System.out.println("C: Complement");
    }

    public static String chooseFunction() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void performFunction(String character,
                                       Pair<ArrayList<Integer>, ArrayList<Integer>> pair) {
        switch (character.toUpperCase()) {
            case "U" -> union(pair);
            case "I" -> intersection(pair);
            case "C" -> {
                Pair<ArrayList<Integer>, String> set = chooseSetToComplement(pair);
                complement(set.first, set.second);
            }
            default -> System.out.println("Wrong choice");
        }
    }

    public static void union(Pair<ArrayList<Integer>,
            ArrayList<Integer>> pair) {
        ArrayList<Integer> result;
        if (pair.first.size() >= pair.second.size()) {
            result = new ArrayList<>(pair.first);
            for (int i = 0; i < pair.second.size(); i++) {
                int value = pair.second.get(i);
                if (!pair.first.contains(value)) {
                    result.add(pair.second.get(i));
                }
            }
        } else {
            result = new ArrayList<>(pair.second);
            for (int i = 0; i < pair.first.size(); i++) {
                int value = pair.first.get(i);
                if (!pair.second.contains(value)) {
                    result.add(pair.first.get(i));
                }
            }
        }
        System.out.println("A \u222A B = " + result);
    }

    public static void intersection(Pair<ArrayList<Integer>,
            ArrayList<Integer>> pair) {
        ArrayList<Integer> result = new ArrayList<>();
        if (pair.first.size() >= pair.second.size()) {
            for (int i = 0; i < pair.second.size(); i++) {
                if (pair.first.contains(pair.second.get(i))) {
                    result.add(pair.second.get(i));
                }
            }
        } else {
            for (int i = 0; i < pair.first.size(); i++) {
                if (pair.second.contains(pair.first.get(i))) {
                    result.add(pair.first.get(i));
                }
            }
        }
        if (!result.isEmpty()) {
            System.out.println("A \u2229 B = " + result);
        } else {
            System.out.println("A \u2229 B = \u2205");
        }
    }

    public static Pair<ArrayList<Integer>, String> chooseSetToComplement(
            Pair<ArrayList<Integer>, ArrayList<Integer>> pair) {
        Pair<ArrayList<Integer>, String> p = new Pair<>(new ArrayList<>(), "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Set to complement");
        String set = scanner.nextLine();
        switch (set.toUpperCase()) {
            case "A" -> {
                p.first = pair.second;
                p.second = "A";
            }
            case "B" -> {
                p.first = pair.first;
                p.second = "B";
            }
        }
        return p;
    }

    public static void complement(ArrayList<Integer> set, String character) {
        System.out.println(character + "\u2201 = " + set);
    }
}
