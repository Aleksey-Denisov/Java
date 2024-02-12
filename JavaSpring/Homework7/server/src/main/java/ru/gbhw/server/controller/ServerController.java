package ru.gbhw.server.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
//Контроллер, роль которого в данном случае вертать картинку
@RestController
public class ServerController {
    @GetMapping("/cat")
    public ResponseEntity<byte[]> getCat() {
        //Рабочие переменные
        byte[] image = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        //Картинку положил в корень проекта, ее беру перевожу в массив байт
        //Тут же соберу заголовок запроса
        try(InputStream inputStream = new FileInputStream("cat.jpg")) {
            image = inputStream.readAllBytes();
            httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        }
        catch (IOException ignored) {}
        return new ResponseEntity<>(image, httpHeaders, HttpStatus.OK);
    }
}
