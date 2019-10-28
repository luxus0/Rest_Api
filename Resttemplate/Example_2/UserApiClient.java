package lukasz.nowogorski.SpringBoot.REST_TEMPLATE;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserApiClient
{

    private static void addUserFromClient()
    {
        RestTemplate restTemplate = new RestTemplate();

        String jsonToSent = "{\"name\":\"mouse\",\"surname\": \"asdds\", \"age\": 34, \"adress\":\"mouse\",\"email\": \"asdds\", \"pesel\": 3445664 }";

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity entity = new HttpEntity(jsonToSent,headers);

        ResponseEntity response = restTemplate.exchange("http://localhost:8080/addUser",
                                                            HttpMethod.POST,
                                                            entity,
                                                             Void.class);
    }

    private static void getUserFromClient()
    {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User[]> response = restTemplate.exchange("http://localhost:8080/getUser",
                                                                    HttpMethod.GET,
                                                                    HttpEntity.EMPTY,
                                                                    User[].class);

        System.out.println("Response Header: " +response.getHeaders());
        Arrays.asList(response.getBody() ).forEach(System.out::println);
        System.out.println("Status code: " +response.getStatusCode());

        System.out.println("Status code value: " +response.getStatusCodeValue() );
    }

    public static  void deleteUserFromClient()
    {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity response = restTemplate.exchange("http://localhost:8080/deleteUser",
                                                        HttpMethod.DELETE,
                                                        HttpEntity.EMPTY,
                                                        Void.class);

    }

   private static void updateUserFromClient()
    {
        RestTemplate restTemplate = new RestTemplate();

        User user = new User();


        String jsonToSent = "{\"name\":\"Direks\",\"surname\": \"Barent\", \"age\": 22, \"adress\":\"Jakuza\",\"email\": \"frento 234\", \"pesel\": 34557790 }";
        String uri = "http://localhost:8080/updateUser/{id}";

        Map<String,String> map = new HashMap<>();
        map.put("id","1");




        HttpEntity httpEntity = new HttpEntity<>(jsonToSent);

        restTemplate.put(uri,user,map);
        //ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8080/updateUser/{id}",HttpMethod.PUT,httpEntity,Void.class,HttpStatus.OK);

    }

    public static void main(String args[])
    {

        getUserFromClient();
       addUserFromClient();
        updateUserFromClient();

        System.out.println("DELETE ALL LIST USERS?? PRESS Y/N");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine() == "Y")
        {
            deleteUserFromClient();
        }
        else
        {
            System.out.println("ALL LIST USER");
        }
    }
}
