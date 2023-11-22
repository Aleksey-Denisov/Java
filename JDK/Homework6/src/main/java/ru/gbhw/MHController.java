package ru.gbhw;

import java.util.*;

public class MHController {
    private MontyHall montyHall;
    private final int COUNTPLAYS = 1000;
    private Map<Integer, Boolean> result;

    public MHController(){
        result = new HashMap<>();
        play();
        getStat();
    }

    private void play() {
        for(int step = 0; step < COUNTPLAYS; step++) {
            //Начнем игру, получим индекс двери с автомобилем
            montyHall = new MontyHall(getRandom());
            System.out.println("Приз находится за дверью: " + montyHall.getPrizeId());
            //Игрок выбирает дверь с номером
            montyHall.setChoisePlayer(getRandom());
            System.out.println("Игрок выбирает дверь с номером: " + montyHall.getChoisePlayer());
            //Ведущий открывает дверь
            montyHall.setOpenDoorId(openDoor());
            System.out.println("Ведущий открыл дверь с номером: " + montyHall.getOpenDoorId());
            //Меняем выбор у игрока
            montyHall.setChoisePlayer(finalChoiseDoor());
            System.out.println("Ведущий спрашивает хочет ли поменять выбор у игрока, игрок выбирает дверь: " + montyHall.getChoisePlayer());
            //Записываем результаты в хешмап
            if (montyHall.getPrizeId() == montyHall.getChoisePlayer())
                result.put(step, true);
            else 
                result.put(step, false);
        }
    }
    //Получаем рандомное значение начиная с 1 и 3
    private int getRandom() {
        return new Random().nextInt(1, 3);
    }
    //Функция открытия двери ведущим
    private int openDoor() {
        //Если дверь совпадает с той за которой находится приз, но находится за крайней дверью, возвращаю любую отличную дверь к примеру 1
        if (montyHall.getChoisePlayer() == montyHall.getPrizeId() && montyHall.getChoisePlayer() == 3)
            return 1;
        //Тут проще считать по этому возвращаю любую дверь отличную от выбранной
        else if (montyHall.getChoisePlayer() == montyHall.getPrizeId() && montyHall.getChoisePlayer() != 3)
            return (3 - montyHall.getChoisePlayer());
        //Если двери разные возвращаю ту, которая не была выбрана и за ней нет приза
        else
            return (6 - (montyHall.getChoisePlayer() + montyHall.getPrizeId()));
    }
    //Функция конечного выбора игрока
    private int finalChoiseDoor() {
        //Если меняем выбор то записываем по формуле сумма номеров всех дверей минус сумма индекса открытой и выбранной
        if(new Random().nextBoolean())
            return (6 - (montyHall.getChoisePlayer() + montyHall.getOpenDoorId()));
        //Иначе не меняем выбор, оставляем как есть
        else
            return montyHall.getChoisePlayer();
    }
    //Функция сбора статистики игр
    private void getStat() {
        int countWin = 0, countLos = 0;
        for(Boolean answer : result.values()){
            if(answer)
                countWin++;
            else
                countLos++;
        }
        //Произошла заминка с расчетами, сразу посчитал на что делить
        double pr = COUNTPLAYS * 0.01;
        System.out.println("Всего игр было: " + COUNTPLAYS +
                        "\nПроцент выигрыша всех игр составляет: " + (countWin / pr) +
                        "%\nПроцент проигрышей всех ирг составляет: " + (countLos / pr) + "%");
    }
}
