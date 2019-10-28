package spring_boot.spring_boot.rest;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class BicycleGui extends VerticalLayout{

    @Autowired
    private BicycleRepo bicycleRepo;
    private Bicycle bicycle;
    private BicycleService bicycleService;


   private TextField textFieldName;
   private TextField textfieldMark;
   private TextField textfieldModel;
   private TextField textfieldYear;
   private TextField textFieldSize;
   private TextField textFieldPrice;
   private Button add;
   private Button delete;
   private Button deleteAll;
   private Button showButtons;

   public BicycleGui()
   {
       textFieldName = new TextField("Name");
       textfieldMark = new TextField("Mark");
       textfieldModel = new TextField("Model");
       textfieldYear = new TextField("Year");
       textFieldSize = new TextField("Size");
        textFieldPrice = new TextField("Price");


        add = new Button("ADD", new Icon(VaadinIcon.ADD_DOCK) );
        delete = new Button("DELETE, ", new Icon(VaadinIcon.DEL));
       deleteAll = new Button("DELETE ALL, ", new Icon(VaadinIcon.DEL_A));


        add.addClickListener(p ->{
            addBicycleDB();
            Notification.show("ADD TO DATABASE",2000, Notification.Position.TOP_CENTER);
        });

        delete.addClickListener(e ->{
            bicycleService.deleteBicycle();
            Notification.show("DELETE RECORD FROM DATABASE",2000, Notification.Position.TOP_CENTER);
        });

        deleteAll.addClickListener(e ->{
            bicycleService.deleteAllBicycle();
            Notification.show("DELETE ALL RECORD FROM DATABASE",2000, Notification.Position.TOP_CENTER);
        });



        add(textFieldName,textfieldMark,textfieldModel,textfieldYear,textFieldSize,textFieldPrice,add,delete,deleteAll);

   }


   public void addBicycleDB()
   {
        bicycle = new Bicycle(textFieldName.getValue(), textfieldMark.getValue(), textfieldModel.getValue(), Integer.parseInt(textfieldYear.getValue() ), Integer.parseInt(textFieldSize.getValue() ), Double.parseDouble(textFieldPrice.getValue()) );
        bicycleRepo.save(bicycle);
   }



}
