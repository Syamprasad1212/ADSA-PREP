import java.util.*;

class Item {
    int weight, profit;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int capacity, Item[] items) {

        // Sort items based on profit/weight ratio (descending)
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.profit / a.weight;
            double r2 = (double) b.profit / b.weight;
            return Double.compare(r2, r1);
        });

        double totalProfit = 0.0;

        for (Item item : items) {

            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalProfit += item.profit;
            } 
            else {
                totalProfit += item.profit * ((double) capacity / item.weight);
                break;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter profit and weight of each item:");
        for (int i = 0; i < n; i++) {
            int profit = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(profit, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxProfit = fractionalKnapsack(capacity, items);

        System.out.println("Maximum Profit = " + maxProfit);

        sc.close();
    }
}
