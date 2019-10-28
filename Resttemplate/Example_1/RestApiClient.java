package spring_boot.spring_boot.Resttemplate.Example_1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RestApiClient {


    @Autowired
    private static RegisterRepo repo;


    public static void getRegister()
    {
        String url = "http://localhost:8090/getRegister";

        RestTemplate restTemplate = new RestTemplate();


        ResponseEntity getforEnity = restTemplate.getForEntity(url,Void.class);
        System.out.println("BODY: " +getforEnity.getBody() + " STATUS CODE: "+ getforEnity.getStatusCode() +
               "STATUS CODE VALUE: " +getforEnity.getStatusCodeValue() +"HEADERS:"  +getforEnity.getHeaders());

    }

    public static void getRegisterById()
    {
        String url = "http://localhost:8090/getRegister/{id}";


        Map<String,Integer> map = new HashMap<>();
        map.put("id",1);
        map.put("id",2);
        map.put("id",3);
        map.put("id",4);

        RestTemplate rest = new RestTemplate();

        Register result = rest.getForObject(url,Register.class,map);
        System.out.println(result);
    }

    @GetMapping("/getRegister/{id}")
    public static ResponseEntity<Register> getRegisterByIdY(@PathVariable long id)
    {
        Register register = new Register("Jelce","Male","12.07.2004",90,"good");
        Register register2 = new Register("Birak","Male","23.10.2007",86,"Jakurta");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT_CHARSET,MediaType.APPLICATION_JSON_UTF8_VALUE);

        ResponseEntity.ok(id);
        return new ResponseEntity<Register>(register,headers, HttpStatus.OK);

    }

    public static String getRegisterXML()
    {
        RestTemplate restTemplate = new RestTemplate();

        Map<String,String> map = new HashMap<>();
        map.put("Mateo","Vukic");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_XML_VALUE);


        HttpHeaders headers2 = new HttpHeaders();
        headers2.put("1", Arrays.asList(MediaType.APPLICATION_PDF_VALUE));

        HttpEntity entity = new HttpEntity(headers);


       restTemplate.exchange("http://localhost:8090/getRegister",HttpMethod.GET,entity,Void.class,map);
        restTemplate.getForEntity("http://localhost:8090/getRegister",Void.class);

       ResponseEntity.ok();
       ResponseEntity.accepted();

        return "model";

    }

    @PostMapping("/createRegister")
    public static ResponseEntity<Register> createRegister(@RequestBody Register register)
    {
        register = new Register("Brasiele","Female","30.10.2008",90,"USA");
        Register register2 = new Register("Jakies","Male","30.10.2010",82,"Brasil");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT_ENCODING,MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        HttpEntity entity = new HttpEntity(headers);
System.out.println(register.getId() +" " + register.getName() + " " +register.getGender() + " " +register.getWeight() + " " +register.getDateOfBirth() + " " + register.getDestination());
        return new ResponseEntity<Register>(HttpStatus.CREATED);
    }

    public static void createRegister2()
    {

        String url = "http://localhost:8090/addRegister";
        RestTemplate restTemplate = new RestTemplate();

        Register register = new Register("Brasiele","Female","30.10.2008",90,"USA");
        Register register2 = new Register("Jakies","Male","30.10.2010",82,"Brasil");


        HttpHeaders headers = new HttpHeaders();
        headers.put(HttpHeaders.ACCEPT_LANGUAGE,new ArrayList<>(Arrays.asList("en-us","de","pl")));
        headers.getAcceptLanguageAsLocales().add(new Locale(Locale.FRANCE.getLanguage(),Locale.ITALY.getCountry()));

        HttpEntity entity = new HttpEntity(headers);
        System.out.println("Body: " +entity.getBody());

        restTemplate.postForObject(url,register,Register.class);
        restTemplate.postForObject(url,register2,Register.class);

        try {


            repo.save(register);
            repo.save(register2);
        }
        catch(NullPointerException ex)
        {
            System.out.println("Null pointer show the reason is that the value is in the table ");
            ex.printStackTrace();
        }


    }

    public static void createRegister3()
    {
        String url = "http://localhost:8090/addRegister";

        Map<String,Integer> map = new HashMap<>();
        map.put("id",8);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("id",10);


        RestTemplate restTemplate = new RestTemplate();

        Register register = new Register("Dany","Male","28.12.2005",77,"USA");
        Register register2 = new Register("Wiily","Onzela","09.10.2001",82,"Brasil");


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AGE,MediaType.ALL_VALUE);

        restTemplate.postForEntity(url,register,Register.class,map);
        restTemplate.postForEntity(url,register2,Register.class,map2);

        try {
            repo.save(register);
            repo.save(register2);
        }
        catch(NullPointerException e)
        {
            System.out.println("Reister is in the table, so that generate null pointer");
            e.printStackTrace();
        }
    }

    public static ResponseEntity<Register> createRegister4()
    {
        String url = "http://localhost:8090/addRegister";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT_CHARSET,MediaType.ALL_VALUE);

        Map<String,Integer> map = new HashMap<>();
        map.put("weight",65);
        map.put("weight",88);

        Register register = new Register("Dany","Male","28.12.2005",77,"USA");
        Register register2 = new Register("Wiily","Onzela","09.10.2001",82,"Brasil");


        rest.postForLocation(url,register,map);
        rest.postForLocation(url,register2,map);

        try {
            repo.save(register);
            repo.save(register2);
        }
        catch(NullPointerException e)
        {
            System.out.println("Nulll pointer - reason is that obect is in the table ");
            e.printStackTrace();
        }

        return new ResponseEntity<Register>(HttpStatus.ACCEPTED);
    }

    private static void updateRegister()
    {
        String url = "http://localhost:8090/updateRegister/{id}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "2");

        Register register = new Register("New Name", "Gilly","test@email.com",89,"BRITAIN");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( url, register, params);
    }

    @DeleteMapping("/deleteRegister")
    public static  void deleteRegister()
    {
        String url = "http://localhost:8090/deleteRegister";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);

        repo.deleteAll();
    }

    public static void main(String[] args)
    {

        getRegister();
        getRegisterById();
       getRegisterByIdY(1L);
       getRegisterXML();
       createRegister(new Register());
       createRegister2();
       createRegister3();
       createRegister4();
       updateRegister();


       String choose = new String();
       System.out.println("Delete all register?? Y:N");
       if(choose == "Y") {
           Scanner sc = new Scanner(System.in);
           choose = sc.nextLine();
           deleteRegister();
           System.out.println("DELETE ALL REGISTER");
       }
       else
       {
           System.out.println(" ALL DATABASE REGISTER");
       }

    }
}
