package ma.ecommerce.project.dto;

public class ClientDto {
    private String name;
    private String email ;
    private long phone;

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

    public ClientDto(String name, String email, long phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
