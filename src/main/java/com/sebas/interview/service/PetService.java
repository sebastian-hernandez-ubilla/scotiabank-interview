package com.sebas.interview.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sebas.interview.dto.PetDto;
import com.sebas.interview.dto.PetResponse;

@Service
public class PetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetService.class);
    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet/";

    private RestTemplate restClient = new RestTemplate();

    public PetService() {

    }

    public PetDto getPetById(int id) {

        LOGGER.info("accede a getPetById");

        String url = BASE_URL + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<PetDto> response = restClient.exchange(
                url,
                HttpMethod.GET,
                request,
                PetDto.class);

        
        LOGGER.info("api result: {}", response.getBody());

        return response.getBody();

    }

    public PetResponse createPet(PetDto request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<PetDto> httpRequest = new HttpEntity<>(request, headers);

        ResponseEntity<PetDto> response = restClient.exchange(
                BASE_URL,
                HttpMethod.POST,
                httpRequest,
                PetDto.class);

        PetDto result = response.getBody();

        PetResponse petResponse = new PetResponse();

        petResponse.setTransactionId(UUID.randomUUID().toString());
        petResponse.setDateCreated(LocalDateTime.now());
        petResponse.setStatus(result.getStatus());
        petResponse.setName(result.getName());

        return petResponse;
    }

}
