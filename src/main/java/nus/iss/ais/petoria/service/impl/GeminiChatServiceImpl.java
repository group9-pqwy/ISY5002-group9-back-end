package nus.iss.ais.petoria.service.impl;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.service.GeminiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class GeminiChatServiceImpl implements GeminiChatService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String chat(String inputText) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("input", inputText);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        String flaskUrl = "http://localhost:5000/chat";

        ResponseEntity<Map> response = restTemplate.exchange(
                UriComponentsBuilder.fromHttpUrl(flaskUrl).toUriString(),
                HttpMethod.POST,
                entity,
                Map.class
        );

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            Map<String, Object> responseBody = response.getBody();
            return responseBody.get("response").toString();
        } else {
            return "I'm very sorry! I can't talk to you at the moment.";
        }
    }
}
