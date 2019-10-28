package spring_boot.spring_boot.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Bicycle
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String mark;
    private String model;
    private int year;
    private int size;
    private double price;

    public Bicycle(){}
    public Bicycle(String name, String mark, String model, int year, int size, double price)
    {
        this.name = name;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.size = size;
        this.price = price;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return id == bicycle.id &&
                year == bicycle.year &&
                size == bicycle.size &&
                Double.compare(bicycle.price, price) == 0 &&
                Objects.equals(name, bicycle.name) &&
                Objects.equals(mark, bicycle.mark) &&
                Objects.equals(model, bicycle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mark, model, year, size, price);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", size=" + size +
                ", price=" + price +
                '}';
    }


}


