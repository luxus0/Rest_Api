package spring_boot.spring_boot.Resttemplate.Example_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegisterRest {

    @Autowired
    private RegisterRepo repo;


    @GetMapping("/getRegister")
    public List<Register> getAllRegister()
    {
        return repo.findAll();
    }

    @GetMapping("/getRegister/{id}")
    public Register getRegisterById(@PathVariable("id") long id)
    {
        return repo.findById(id).get();
    }

    @PostMapping("/addRegister")
    public void addRegister(@RequestBody Register register)
    {
        repo.save(register);
    }

    @PutMapping("/updateRegister/{id}")
    public Optional<Register> updateRegister(@PathVariable("id") Long id, @RequestBody Register register)
    {
        register.setName("Maria");
        register.setGender("Female");
        register.setWeight(70);
        register.setDateOfBirth("24.05.2018");
        register.setDestination("Ocean");

        repo.save(register);

        return repo.findById(id);


    }

    @DeleteMapping("/deleteRegister")
    public void deleteRegister()
    {
        repo.deleteAll();
    }

    @DeleteMapping("/deleteRegister/{id}")
    public void deleteReisterById(@PathVariable Long id)
    {
        repo.deleteById(id);
    }

}
