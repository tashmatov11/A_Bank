package tashmatov11.db.service.impl;

import tashmatov11.db.models.BankAccount;
import tashmatov11.dto.request.SignupRequestClient;
import tashmatov11.dto.response.MessageResponse;
import tashmatov11.db.models.userClasses.User;
import tashmatov11.db.repository.RoleRepository;
import tashmatov11.db.repository.UserRepository;
import tashmatov11.db.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    @Override
    public ResponseEntity<?> register(SignupRequestClient signupRequestClient, Long number) {

        if (userRepository.existsByEmail(signupRequestClient.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        User user = new User(
                signupRequestClient.getEmail(),
                encoder.encode(signupRequestClient.getPassword()));
        user.setFirstName(signupRequestClient.getFirstName());
        user.setRole(roleRepository.getById(number));
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccount(0);
        bankAccount.setCreatedAt(LocalDate.now()
        );
        bankAccount.setUser(user);
            userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse(
                String.format("User with email %s registered successfully!", user.getEmail().toUpperCase(Locale.ROOT))));
    }


}
