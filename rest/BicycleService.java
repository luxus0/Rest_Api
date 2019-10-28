package spring_boot.spring_boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BicycleService {


    private BicycleRepo bicycleRepo;
    private Bicycle bicycle;

    @Autowired
    public BicycleService(BicycleRepo bicycleRepo) {
        this.bicycleRepo = bicycleRepo;
    }


    public List<Bicycle> getAllBicycle()
    {
        List<Bicycle> bicycleList = new ArrayList<>();
        bicycleRepo.findAll().forEach(e -> bicycleList.add(e));
        return bicycleList;
    }

    public Bicycle getBicycleById(long id)
    {
        Bicycle bic = bicycleRepo.findById(id).get();
        return bic;

    }




    @EventListener(ApplicationReadyEvent.class)
    public void addBicycle()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("----ADD BICYCLE TO DATABASE----");
        System.out.println("Ile wierszy?");
        int numberW = sc.nextInt();

        for(int i = 0; i < numberW; i++)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("NAME");
            String name = scanner.nextLine();

            System.out.println("\nMARK");
            String mark = scanner.nextLine();

            System.out.println("\nMODEL");
            String model = scanner.nextLine();

            System.out.println("\nYEAR");
            int year = sc.nextInt();

            System.out.println("\nSIZE");
            int size = scanner.nextInt();

            System.out.println("\nPRICE");
            double price = scanner.nextDouble();

            System.out.println("----------------------------------\n");

            Bicycle bicycle = new Bicycle(name, mark, model, year, size, price);
            bicycleRepo.save(bicycle);
        }
    }

public void updateBicycle(Bicycle bicycle)
{
    bicycleRepo.save(new Bicycle("JUWENTYL","ASERT","GROMNIK",2,3,4));
}

    public void deleteByIdBicycle(long id)
    {
        bicycleRepo.deleteById(id);
    }




    public void deleteBicycle()
    {
        bicycleRepo.delete(bicycle);

    }

    public void deleteAllBicycle()
    {
        bicycleRepo.deleteAll();
    }

    List<Bicycle> findByNameAndMark(String name,String mark)
    {
        return bicycleRepo.findByNameAndMark(bicycle.getName(),bicycle.getMark());
    }

}
