package ma.ecommerce.project.dto;

import org.apache.juli.logging.Log;

public class ProductDto implements Namable{
    private long id;
    private String name;
    private String color;
    private String size; // todo convert to enum
    private long idCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public ProductDto() {
    }

    public ProductDto(long   id, String size , String color, String name) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.name = name;
    }
}
