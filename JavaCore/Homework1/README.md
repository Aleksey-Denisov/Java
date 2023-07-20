# Java Core (семинары)
## Урок 1. Компиляция и интерпретация кода
1. Создать приложение с вложенностью пакетов не менее 3х, где будет класс для входа и несколько классов с логикой. Пример: приложение для внесения заметок во внешний файл с обязательной фиксацией времени
пример:
Введите заметку: Hello, world!
Дозапись в файл: 16.07.2023 -> Hello, world

Скомпилируйте и запустите посредством CLI

Команды для командной строки ОС Windows:
javac -sourcepath ./JavaCore/Homework1/src/ -d JavaCore/Homework1/ourclasses ./JavaCore/Homework1/src/ru/gbhw/java/view/Main.java -encoding utf-8
java -cp .\JavaCore\Homework1\ourclasses\ ru.gbhw.java.view.Main 

2. Создать два Docker-образа. Один должен компилировать Java-проект обратно в папку на компьютере пользователя, а второй забирать скомпилированные классы и исполнять их. Пример листинга для docker-compose приведен в презентации семинара

Выполнялось на ОС Ubuntu, изменились каталоги от первоначальной реализации и в выходной файл note в коде, все остально тоже самое

version: "3.9"

services:
  app:
    image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
    command: javac -sourcepath /src -d /src/out /src/ru/gbhw/java/view/Main.java
    volumes:
      - /src:/src
  app-class:
    image: bellsoft/liberica-openjdk-alpine:11.0.16.1-1
    command: java -cp /src/out/ ru.gbhw.java.view.Main
    volumes:
      - /src:/src

В чем возникла проблема, это с вводом данных, вероятно нужно запускать как то в режиме интерактив или что-то в этом роде
