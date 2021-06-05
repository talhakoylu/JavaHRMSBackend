package net.ahmettalha.javahrmsbackend.core.verificationServices.mernis.adapters;

import org.springframework.stereotype.Component;

@Component("fake_mernis")
public class FakeMernisService implements MernisVerificationService{
    @Override
    public boolean realPersonVerification(String nationalIdNo, String firstName, String lastName, int birthYear) {
        return true;
    }
}
