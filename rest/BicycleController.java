package spring_boot.spring_boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BicycleController
{
    @Autowired
    private BicycleService bicycleService;

    @GetMapping("/bicycles")
    private List<Bicycle> getBicycle()
    {
        return bicycleService.getAllBicycle();
    }

    @GetMapping("/bicycles/{id}")
    private Bicycle getBicycleById(@PathVariable long id)
    {
        return bicycleService.getBicycleById(id);
    }

    @PostMapping("/createbicycles")
    @ResponseStatus(HttpStatus.CREATED)
    private void addBicycle(@RequestBody Bicycle bicycle)
    {
        bicycleService.addBicycle();
    }

    @PutMapping("/updatebicycles/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateBicycle(@PathVariable Long id, @RequestBody Bicycle bicycle)
    {
        bicycleService.updateBicycle(bicycle);
    }



    @DeleteMapping("/removebicycles")
    @ResponseStatus(HttpStatus.OK)
    private void deleteBicycle()
    {
        bicycleService.deleteBicycle();
    }

    @DeleteMapping("/removebicycles/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void deletebyId(@PathVariable("id") Long id)
    {
        bicycleService.deleteByIdBicycle(id);
    }
}
