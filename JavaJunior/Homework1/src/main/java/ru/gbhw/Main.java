package main.java.ru.gbhw;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        streamAVG();
    }

    private static void streamAVG() {
        ArrayList<Integer> arrayList = (ArrayList<Integer>) new Random()
            .ints(100, 0, 100).mapToObj(Integer::valueOf)
            .collect(Collectors.toList());

        System.out.println(arrayList.stream().filter(element -> element % 2 ==0)
            .mapToInt(element -> element).average().getAsDouble());
    }


    //Вырезка измененной функции балансировки корзины
    /*public void cardBalancing()
    {
        boolean[] proteins = {false};
        boolean[] fats = {false};
        boolean[] carbohydrates = {false};

        foodstuffs.stream().filter(clazz :: isInstance).forEach(foodstuff -> {
            if (!proteins[0] && foodstuff.getProteins())
                proteins[0] = true;
            else
            if (!fats[0] && foodstuff.getFats())
                fats[0] = true;
            else
            if (!carbohydrates[0] && foodstuff.getCarbohydrates())
                carbohydrates[0] = true;
        });

        if (proteins[0] && fats[0] && carbohydrates[0])
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        market.getThings(Food.class).stream().filter(clazz::isInstance).forEach(thing -> {
            if (!proteins[0] && thing.getProteins())
            {
                proteins[0] = true;
                foodstuffs.add((T) thing);
            }
            else if (!fats[0] && thing.getFats())
            {
                fats[0] = true;
                foodstuffs.add((T) thing);
            }
            else if (!carbohydrates[0] && thing.getCarbohydrates())
            {
                carbohydrates[0] = true;
                foodstuffs.add((T) thing);
            }
        });

        if (proteins[0] && fats[0] && carbohydrates[0])
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }*/
}
