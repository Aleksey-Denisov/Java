package ru.gbhw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.*;

public class StudentList {
    public static final String FILE_JSON = "student.json";
    public static final String FILE_XML = "student.xml";
    public static final String FILE_BIN = "student.bin";
    public static final String FILE_SER = "student.ser";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    //Сериализация класса с интерфейсом Serializable
    public void serializableStudent(List<StudentSer> studentList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_SER))) {
            oos.writeObject(studentList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Десериализация класса с интерфейсом Serializable
    public List<StudentSer> deserializableStudent() {
        List<StudentSer> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_SER))) {
            //Не люблю подсвечивающиеся поля, по этому просто убрал проверку, но не без лишних перекладок
            @SuppressWarnings("unchecked")
            List<StudentSer> temp = (List<StudentSer>) ois.readObject();
            students = temp;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
    //Сериализация с интерфейсом Externalizable
    public void saveFile(List<Student> studentList) {
        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), studentList);
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(FILE_XML), studentList);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_BIN))) {
                oos.writeObject(studentList);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Возвращаем обратно данные из файлов
    public List<Student> readFile(String fileName) {
        List<Student> studentList = new ArrayList<>();
        File f = new File(fileName);
        if(f.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    studentList = objectMapper.readValue(f, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".xml")) {
                    studentList = xmlMapper.readValue(f, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        //Аналогично предыдущей функции
                        @SuppressWarnings("unchecked")
                        List<Student> temp = (List<Student>) ois.readObject();
                        studentList = temp;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.printf("\nДанного файла %s не существует\n", fileName);
        }
        return studentList;
    }
    //Функция для просмотра списков
    public void showList(List<?> studentList) {
        studentList.forEach(System.out::println);
    }
}
