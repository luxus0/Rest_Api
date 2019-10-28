package lukasz.nowogorski.SpringBoot.REST_TEMPLATE;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserApi {

    private List<User> userList;

    public UserApi()
    {
        userList = new ArrayList<>();

        userList.add(new User("Liker",
                                "Maniejk",
                                    23,
                                "Grenweld 23",
                                "mikos@o2.pl",
                            3456322));

        userList.add(new User("merico",
                "Vesiko",
                34,
                "Merinda 33",
                "Vladimir@host.pl",
                4567898));

        userList.add(new User("Jatek",
                "ridonda",
                21,
                "Valites 33",
                "Jeremys@in.pl",
                5374565));

        userList.add(new User("Barita",
                "Corrida",
                21,
                "Natesuz 33",
                "braqtswa@in.pl",
                645654654));

    }

    @GetMapping("/getUser")
    public List<User> getUser()
    {
        return userList;
    }


    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)
    {
           userList.add(user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable long id,@RequestBody User user) {

        user.setId(0);
        user.setName("Menic");
        user.setSurname("Vasko");
        user.setAge(20);
        user.setEmail("bratska@o2.pl");
        user.setPesel(6576765);
        user.setAdress("Marta Vielka 779");


        user.setId(1);
        user.setName("monta");
        user.setSurname("akiej");
        user.setAge(23);
        user.setEmail("fsdfd@o2.pl");
        user.setPesel(654646666);
        user.setAdress("JUlenko Street");

        user.setId(2);
        user.setName("Luki");
        user.setSurname("Franki");
        user.setAge(45);
        user.setEmail("jowenycji@o2.pl");
        user.setPesel(898779887);
        user.setAdress("Barela Moric");

        user.setId(3);
        user.setName("Meris");
        user.setSurname("Valupin");
        user.setAge(21);
        user.setEmail("durendsal@o2.pl");
        user.setPesel(768787);
        user.setAdress("Barela Moric");

        userList.add(user);


    }
    @DeleteMapping("/deleteUser")
    public void deleteUser()
    {
        userList.clear();
        System.out.println(userList.iterator().next());
    }





}
