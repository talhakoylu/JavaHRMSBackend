package net.ahmettalha.javahrmsbackend.core.verificationServices.mernis.adapters;

import net.ahmettalha.javahrmsbackend.core.verificationServices.mernis.IMDKPSPublicSoap12;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("real_mernis")
public class MernisVerificationManager implements MernisVerificationService{

    private IMDKPSPublicSoap12 client = new IMDKPSPublicSoap12();

    @Override
    public boolean realPersonVerification(String nationalIdNo, String firstName, String lastName, int birthYear) {
        try{
            return client.TCKimlikNoDogrula(Long.parseLong(nationalIdNo), firstName.toUpperCase(), lastName.toUpperCase(), birthYear);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
