package com.company.kunuz.Controller;

import com.company.kunuz.DTO.Auth.LoginDTO;
import com.company.kunuz.DTO.Auth.RegistrationDTO;
import com.company.kunuz.DTO.Profile.ProfileDTO;
import com.company.kunuz.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/registrationByPhone")
    public ResponseEntity<String> registrationByPhone(@Valid @RequestBody RegistrationDTO dto) {
        String body = authService.registrationByPhone(dto);
        return ResponseEntity.ok().body(body);
    }
    @GetMapping("/verificationByPhone/{userId}")
    public ResponseEntity<String> verificationByPhone(@PathVariable("userId") Integer userId) {
        String body = authService.authorizationVerificationByPhone(userId);
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("/registrationByEmail/resend/{email}")
    public ResponseEntity<String> registrationResendByEmail(@PathVariable("email") String email) {
        String body = authService.registrationResendByEmail(email);
        return ResponseEntity.ok().body(body);
    }

    @GetMapping("/registrationByPhone/resend/{phone}")
    public ResponseEntity<String> registrationResendByPhone(@PathVariable("phone") String phone) {
        String body = authService.registrationResendByPhone(phone);
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("/registrationByEmail")
    public ResponseEntity<String> registrationByEmail(@Valid @RequestBody RegistrationDTO dto) {
        String body = authService.registrationByEmail(dto);
        return ResponseEntity.ok().body(body);
    }
    @GetMapping("/verificationByEmail/{userId}")
    public ResponseEntity<String> verificationByEmail(@PathVariable("userId") Integer userId) {
        String body = authService.authorizationVerificationByEmail(userId);
        return ResponseEntity.ok().body(body);
    }

    @PostMapping("/login")
    public ResponseEntity<ProfileDTO> registrationByEmail(@Valid @RequestBody LoginDTO dto) {
        ProfileDTO body = authService.login(dto);
        return ResponseEntity.ok().body(body);
    }

}
