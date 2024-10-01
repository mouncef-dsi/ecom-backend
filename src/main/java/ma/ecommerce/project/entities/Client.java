package ma.ecommerce.project.entities;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ECOM_CLIENT" )
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private long phone;
    @OneToMany (mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }


    public Client(long id, String name, String email, long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Client() {

    }
}
