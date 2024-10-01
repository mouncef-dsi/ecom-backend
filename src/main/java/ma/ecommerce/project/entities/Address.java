package ma.ecommerce.project.entities;


import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "ECOM_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address(long id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }
    public Address() {

    }
}
