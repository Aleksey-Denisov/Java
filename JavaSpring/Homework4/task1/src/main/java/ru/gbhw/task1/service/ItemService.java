package ru.gbhw.task1.service;

import org.springframework.stereotype.Service;
import ru.gbhw.task1.model.Item;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    //Список для хранения всех элементов
    private List<Item> items = new ArrayList<>();
    //Получу все
    public List<Item> getItems() {
        return items;
    }
    //Добавлю элемент
    public void addItem(Item item) {
        items.add(item);
    }
}
