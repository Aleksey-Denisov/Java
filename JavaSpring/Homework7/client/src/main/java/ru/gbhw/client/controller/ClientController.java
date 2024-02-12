package ru.gbhw.client.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Base64;

@Controller
@AllArgsConstructor
public class ClientController {
    private OAuth2AuthorizedClientService authorizedClientService;
    //Откроем страницу
    @GetMapping
    public String getPage(Model model, Principal principal) {
        RestTemplate template = new RestTemplate();
        //Строка с токеном
        String token = authorizedClientService
                .loadAuthorizedClient("reg-client", principal.getName())
                .getAccessToken().getTokenValue();
        //Тут необходимо создать заголовок
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        //получаем сущность по сформированному заголовку
        HttpEntity<String> entity = new HttpEntity<>(headers);
        //Извлечем массив данных из шаблона по адресу
        ResponseEntity<byte[]> response =
                template.exchange("http://localhost:8081/cat",
                        HttpMethod.GET, entity, byte[].class);
        //Добавим запрашиваемое в параметры на страницу.
        model.addAttribute("cat", Base64.getEncoder().encodeToString(response.getBody()));
        return "page";
    }
}
