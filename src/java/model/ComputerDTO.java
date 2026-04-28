/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class ComputerDTO {
    private String id;
    private String name;
    private String description;
    private String ram;
    private int price;

    public ComputerDTO(String id, String name, String description, String ram, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ram = ram;
        this.price = price;
    }

    public ComputerDTO(String name, String ram, int price) {
        this.name = name;
        this.ram = ram;
        this.price = price;
    }
    
    public ComputerDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", name=" + name + ", description=" + description + ", ram=" + ram + ", price=" + price ;
    }
    
    
}
