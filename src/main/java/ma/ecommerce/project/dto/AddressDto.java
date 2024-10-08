package ma.ecommerce.project.dto;

public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private Long idClient;

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public AddressDto() {

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getIdClient() {

        return idClient;
    }

    public void setIdClient(Long idClient) {

        this.idClient = idClient;
    }

    public AddressDto(Long id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }
}
