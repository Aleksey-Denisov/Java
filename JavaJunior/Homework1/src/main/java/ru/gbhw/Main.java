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
    /**
     * Балансировка корзины
     */
    /*public void cardBalancing()
    {
        boolean proteins = checkNutrientFlag(Food::getProteins);
        boolean fats = checkNutrientFlag(Food::getFats);
        boolean carbohydrates = checkNutrientFlag(Food::getCarbohydrates);

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        Collection<T> marketFoods = market.getThings(clazz);
        proteins = checkNutrientFlag(proteins, Food::getProteins, marketFoods);
        fats = checkNutrientFlag(fats, Food::getFats, marketFoods);
        carbohydrates = checkNutrientFlag(carbohydrates, Food::getCarbohydrates, marketFoods);

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        }

    }*/

    /**
     * Проверка наличия конкретного питательного элемента в корзине
     * @param nutrientCheck список продуктов в корзине
     * @return состояние обновленного флага питательного элемента
     */
    /*private boolean checkNutrientFlag(Predicate<Food> nutrientCheck) {
        Optional<T> optionalFood = foodstuffs.stream()
                .filter(nutrientCheck)
                .findFirst();
        return optionalFood.isPresent();
    }*/

        /**
     * Поиск недостающих питательных элементов в корзине и добавление питательно элемента
     * исходя из общего фильтра продуктов
     * @param nutrientFlag наличие питательного элемента
     * @param nutrientCheck список продуктов в корзине
     * @param foods доступный список продуктов (исходя из текущего фильтра)
     * @return состояние обновленного флага питательного элемента (скорее всего будет true,
     * false - в случае, если невозможно найти продукт с нужным питательным элементом, в таком
     * случае, невозможно сбалансировать корзину по БЖУ
     */
    /*private boolean checkNutrientFlag(boolean nutrientFlag, Predicate<Food> nutrientCheck, Collection<T> foods) {
        if (!nutrientFlag) {
            Optional<T> optionalFood = foods.stream()
                    .filter(nutrientCheck)
                    .findFirst();
            optionalFood.ifPresent(foodstuffs::add);
            return optionalFood.isPresent();
        }
        return true;
    }*/

}
