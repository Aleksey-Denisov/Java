package ru.gbhw;

import java.util.*;

import static ru.gbhw.StudentList.*;

public class Main {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        System.out.println("Первым делом выполним задачу с помощью интерфейса Serializable\nНа входе будут следующие данные:");
        List<StudentSer> listSer = addStudentsSer();
        studentList.showList(listSer);
        studentList.serializableStudent(listSer);
        System.out.println("Результат после десериализации");
        studentList.showList(studentList.deserializableStudent());
        //Поле GPA не было сериализовано, так как перед ним стоит конструкция, которая игнорирует данное поле, получили 0.00
        System.out.println("---------------------------------------------");
        System.out.println("Теперь посмотрим как аналогичные действия будет выполнять Externalizable");
        List<Student> list = addStudents();
        System.out.println("Вывод всех студентов до сериализации");
        studentList.showList(list);
        studentList.saveFile(list);

        System.out.println("Вывод всех студентов после десериализации из файла json");
        studentList.showList(studentList.readFile(FILE_JSON));

        System.out.println("Вывод всех студентов после десериализации из файла xml");
        studentList.showList(studentList.readFile(FILE_XML));
        //А чтобы сюда не попали поля, их помечаем аннотацией

        System.out.println("Вывод всех студентов после десериализации из файла bin");
        studentList.showList(studentList.readFile(FILE_BIN));
        //Тут интереснее, так как сами настраиваем, что нам нужно, а что нет.
        //при записи и чтении в функциях не добавили поля, их и нет
    }

    private static List<Student> addStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Владимир", 17, 3.48));
        students.add(new Student("Дмитрий", 18, 4.25));
        students.add(new Student("Александр", 16, 3.98));
        return students;
    }
    //Пришлось чуть задублировать, чтобы наверняка убедиться, что созданы необходимые экземпляры класса
    //До этого закастовал и все тоже самое было, но все равно появились сомнения. Так надежнее.
    private static List<StudentSer> addStudentsSer() {
        ArrayList<StudentSer> students = new ArrayList<>();
        students.add(new StudentSer("Владимир", 17, 3.48));
        students.add(new StudentSer("Дмитрий", 18, 4.25));
        students.add(new StudentSer("Александр", 16, 3.98));
        return students;
    }
}