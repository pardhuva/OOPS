import java.util.*;

public class S20230010045_toc_ouput {
    // Grammar in CNF
    static Map<String, List<List<String>>> grammar = new HashMap<>();

    public static void main(String[] args) {
        // Define the grammar
        addProduction("S", Arrays.asList("A", "B"));
        addProduction("S", Arrays.asList("X", "B"));

        addProduction("T", Arrays.asList("A", "B"));
        addProduction("T", Arrays.asList("X", "B"));

        addProduction("X", Arrays.asList("A", "T"));

        addProduction("A", Arrays.asList("a"));
        addProduction("B", Arrays.asList("b"));

        // Take user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check with CYK: ");
        String input = scanner.nextLine();

        boolean result = cyk(input);
        System.out.println("Result: " + (result ? "Accepted (belongs to the grammar)" : "Rejected (does not belong to the grammar)"));
    }

    // Add production rule
    static void addProduction(String variable, List<String> production) {
        grammar.computeIfAbsent(variable, k -> new ArrayList<>()).add(production);
    }

    // CYK algorithm implementation
    @SuppressWarnings("unchecked")
    static boolean cyk(String input) {
        int n = input.length();
        if (n == 0) return false;

        Set<String>[][] table = new HashSet[n][n];

        // Initialize table
        for (int i = 0; i < n; i++) {
            table[i][i] = new HashSet<>();
            for (String variable : grammar.keySet()) {
                for (List<String> production : grammar.get(variable)) {
                    if (production.size() == 1 && production.get(0).equals(String.valueOf(input.charAt(i)))) {
                        table[i][i].add(variable);
                    }
                }
            }
        }

        // CYK main loop
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                table[i][j] = new HashSet<>();
                for (int k = i; k < j; k++) {
                    for (String variable : grammar.keySet()) {
                        for (List<String> production : grammar.get(variable)) {
                            if (production.size() == 2) {
                                String B = production.get(0);
                                String C = production.get(1);
                                if (table[i][k].contains(B) && table[k + 1][j].contains(C)) {
                                    table[i][j].add(variable);
                                }
                            }
                        }
                    }
                }
            }
        }

        return table[0][n - 1].contains("S");
    }
}