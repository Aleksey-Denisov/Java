package ru.gbhw.task1.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gbhw.task1.model.Item;
import ru.gbhw.task1.service.ItemService;

@Controller
@AllArgsConstructor
@Log
public class ItemController {
    //Объявляю сервис
    private final ItemService itemService;
    //Работа с главной страницей
    @GetMapping
    public String getIndex() {
        //Эксперименты с логом
        log.severe("Зачем обращаться на главную страницу?");
        return "../static/index";
    }
    //Переходим на страницу всего содержимого
    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getItems());
        //Эксперименты с логом
        log.warning("Открыта страница с содержимым");
        return "items";
    }
    //Не стал лепить больше страниц, по этому все на одной
    //получаю и обновляю страницу с новыми данными
    @PostMapping("/items")
    public String addItem(Item item, Model model) {
        itemService.addItem(item);
        model.addAttribute("items", itemService.getItems());
        log.info("Add item: " + item);
        return "items";
    }
}
