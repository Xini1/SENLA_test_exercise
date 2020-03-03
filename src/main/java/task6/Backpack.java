package task6;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int maxWeight;
    private List<Item> contents;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        contents = new ArrayList<>();
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void addItem(Item item) {
        if (getCurrentWeight() + item.getWeight() <= maxWeight) {
            contents.add(item);
        }
    }

    public int getCurrentWeight() {
        return contents.stream()
                .map(Item::getWeight)
                .reduce(0, Integer::sum);
    }

    public int getCurrentValue() {
        return contents.stream()
                .map(Item::getValue)
                .reduce(0, Integer::sum);
    }

    public void printContents() {
        contents.forEach(System.out::println);
    }
}
