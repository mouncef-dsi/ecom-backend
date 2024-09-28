package ma.ecommerce.project.dto;

public class ProductDto {

    private String name;
    private String color;
    private String size; // todo convert to enum


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ProductDto() {
    }

    public ProductDto(String size, String color, String name) {
        this.size = size;
        this.color = color;
        this.name = name;
    }
}
