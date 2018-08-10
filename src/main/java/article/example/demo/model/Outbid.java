package article.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "outbids")
public class Outbid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String nameFraction;

    private long goldForBuy;
    private long goldForSale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameFraction() {
        return nameFraction;
    }

    public void setNameFraction(String nameFraction) {
        this.nameFraction = nameFraction;
    }

    public long getGoldForBuy() {
        return goldForBuy;
    }

    public void setGoldForBuy(long goldForBuy) {
        this.goldForBuy = goldForBuy;
    }

    public long getGoldForSale() {
        return goldForSale;
    }

    public void setGoldForSale(long goldForSale) {
        this.goldForSale = goldForSale;
    }
}
