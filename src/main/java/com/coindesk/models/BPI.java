package com.coindesk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bpi_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USD",
            joinColumns = @JoinColumn(name = "bpi_id"),
            inverseJoinColumns = @JoinColumn(name = "USD"))
    private Coin USD;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "GBP",
            joinColumns = @JoinColumn(name = "bpi_id"),
            inverseJoinColumns = @JoinColumn(name = "GBP"))
    private Coin GBP;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "EUR",
            joinColumns = @JoinColumn(name = "bpi_id"),
            inverseJoinColumns = @JoinColumn(name = "EUR"))
    private Coin EUR;

    public BPI() {
    }

    public BPI(Coin USD, Coin GBP, Coin EUR) {
        this.USD = USD;
        this.GBP = GBP;
        this.EUR = EUR;
    }

    public Coin getUSD() {
        return USD;
    }

    public void setUSD(Coin USD) {
        this.USD = USD;
    }

    public Coin getGBP() {
        return GBP;
    }

    public void setGBP(Coin GBP) {
        this.GBP = GBP;
    }

    public Coin getEUR() {
        return EUR;
    }

    public void setEUR(Coin EUR) {
        this.EUR = EUR;
    }

    public Long getId() {
        return bpi_id;
    }

    public void setId(Long bpi_id) {
        this.bpi_id = bpi_id;
    }

    @Override
    public String toString() {
        return "BPI{" +
                "id=" + bpi_id +
                ", USD=" + USD +
                ", GBP=" + GBP +
                ", EUR=" + EUR +
                '}';
    }
}
