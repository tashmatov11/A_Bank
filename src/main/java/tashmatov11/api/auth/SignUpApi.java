package tashmatov11.api.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import tashmatov11.db.service.ClientService;
import tashmatov11.dto.request.SignupRequestClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Tag(name = "AuthController",description = "singup user and  vendor")
public class SignUpApi {

    private ClientService clientService;

    @Operation(summary = "singup", description = "registered client")
    @PostMapping("/signup/client")
    public ResponseEntity<?> registerClient(@Valid @RequestBody SignupRequestClient client) {
        return clientService.register(client, 1L);
    }


}
