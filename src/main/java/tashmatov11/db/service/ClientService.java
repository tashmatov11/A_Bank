package tashmatov11.db.service;

import tashmatov11.dto.request.SignupRequestClient;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<?> register(SignupRequestClient signupRequestClient, Long number);

}
