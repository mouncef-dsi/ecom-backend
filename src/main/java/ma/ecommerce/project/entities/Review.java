package ma.ecommerce.project.entities;
import javax.persistence.Table;
import javax.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


import javax.persistence.*;

@Entity
@Table(name = "ECOM_REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "rating")
    @Min(1)
    @Max(5)
    private int rating;
    @Column(name = "commentaire")
    private String commentaire;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Review() {
    }

    public Review(long id, int rating, String commentaire) {
        this.id = id;
        this.rating = rating;
        this.commentaire = commentaire;
    }

    public Review(long id, int rating, String commentaire, Product product) {
        this.id = id;
        this.rating = rating;
        this.commentaire = commentaire;
        this.product = product;
    }

}
