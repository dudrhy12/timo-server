package timo.timo.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import timo.timo.Domain.Phone;
import timo.timo.Repository.PhoneRepository;

@Service
@RequiredArgsConstructor
public class QRService {

    private final PhoneRepository phoneRepository;

    public boolean findUser(String phoneNumber){
        Phone number = phoneRepository.findByPhoneNumber(phoneNumber);
        if (number != null){
            return true;
        }else{
            return false;
        }
    }

}
