package net.ahmettalha.javahrmsbackend.core.verificationServices.mernis.adapters;

import org.springframework.stereotype.Service;

@Service
public interface MernisVerificationService {
    boolean realPersonVerification(String nationalIdNo, String firstName, String lastName, int birthYear);
}
