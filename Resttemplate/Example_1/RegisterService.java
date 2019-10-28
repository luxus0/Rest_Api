package spring_boot.spring_boot.Resttemplate.Example_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
private RegisterRepo repo;

    @EventListener(ApplicationReadyEvent.class)
    public void saveDB()
    {
        Register register = new Register("Ilona", "FeMale", "12.04.2008", 68, "good");
        Register register2 = new Register("Gregory", "Male", "12.04.2010", 78, "good");
        Register register3 = new Register("Lukas", "Male", "12.04.2012", 70, "good");
        Register register4 = new Register("Mateo", "Vukic", "12.04.2013", 72, "good");
        Register register5 = new Register("Slepek", "Miras", "12.10.2015", 75, "good");

        repo.save(register);
        repo.save(register2);
        repo.save(register3);
        repo.save(register4);
        repo.save(register5);

    }
}
