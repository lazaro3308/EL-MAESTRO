package br.com.elmaestro.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=100) private String slug;
 @NotBlank @Column(nullable=false) private String name;
 @Column(nullable=false,length=40) private String category="MASCULINO";
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=10,scale=2) private BigDecimal price=new BigDecimal("250.00");
 @Min(0) @Column(nullable=false) private int stock=30;
 private String family; private String concentration; private String volume="100 ml";
 @Column(length=2000) private String description;
 @Column(length=1000) private String notes;
 private String imageUrl; private boolean active=true;
 public Product(){}
 public Product(String slug,String name,String family,String concentration,String description,String notes){
  this.slug=slug;this.name=name;this.family=family;this.concentration=concentration;this.description=description;this.notes=notes;
 }
 public Long getId(){return id;} public String getSlug(){return slug;} public void setSlug(String v){slug=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public int getStock(){return stock;} public void setStock(int v){stock=v;}
 public String getFamily(){return family;} public void setFamily(String v){family=v;}
 public String getConcentration(){return concentration;} public void setConcentration(String v){concentration=v;}
 public String getVolume(){return volume;} public void setVolume(String v){volume=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getNotes(){return notes;} public void setNotes(String v){notes=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
 public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}