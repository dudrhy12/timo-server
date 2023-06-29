package timo.timo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import timo.timo.Domain.Phone;

public interface PhoneRepository extends JpaRepository<Phone, String> {

    Phone findByPhoneNumber(String phoneNumber);
}
