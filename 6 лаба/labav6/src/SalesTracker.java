import java.util.*;

public class SalesTracker {
    private Map<String, Integer> sales;
    private Map<String, Integer> itemCount;

    public SalesTracker() {
        sales = new HashMap<>();
        itemCount = new HashMap<>();
    }

    public void addSale(String item, int price) {
        sales.put(item, sales.getOrDefault(item, 0) + price);
        itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
    }

    public void printSales() {
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printTotalSales() {
        int total = sales.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total Sales: " + total);
    }

    public void printMostPopularItem() {
        String mostPopular = Collections.max(itemCount.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most Popular Item: " + mostPopular);
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Item1", 100);
        tracker.addSale("Item2", 150);
        tracker.addSale("Item1", 100);
        tracker.printSales();
        tracker.printTotalSales();
        tracker.printMostPopularItem();
    }
}