package ma.ecommerce.project.dto;

public class ReviewDto {
    private long id;
    private int rating;
    private String commentaire;
    private Long idProduct;


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

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }



    public ReviewDto(long id, int rating, String commentaire) {
        this.id = id;
        this.rating = rating;
        this.commentaire = commentaire;

    }
}
