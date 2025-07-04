import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable>items)
    {
        if(items == null || items.isEmpty()) {
            throw new IllegalArgumentException("No items to ship");
        }
        double totalWeight = 0.0;
        Map<String, Double> itemWeights = new HashMap<>();
        Map<String, Integer> itemCounts = new HashMap<>();
        for (Shippable item : items) {
            String itemName = item.getName();
            double weight = item.getWeight();
            totalWeight += weight;
            itemWeights.put(item.getName(), item.getWeight());
            itemCounts.put(itemName, itemCounts.getOrDefault(itemName, 0) + 1);
        }
        System.out.println("** Shipment notice **");
        for(Map.Entry<String, Double> entry : itemWeights.entrySet()) {
            String name = entry.getKey();
            double weight = entry.getValue();
            int count = itemCounts.get(name);
            System.out.println(  count+"x"+ name + ", Weight: " + weight*count*1000 + " g");//assume weight is in kilograms
        }
        System.out.println("Total Package: " + totalWeight + "kg");
    }
}