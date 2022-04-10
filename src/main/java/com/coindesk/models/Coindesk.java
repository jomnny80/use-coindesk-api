package com.coindesk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "coindesks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coindesk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coin_desk_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "time",
            joinColumns = @JoinColumn(name = "coin_desk_id"),
            inverseJoinColumns = @JoinColumn(name = "time"))
    private Time time;
    private String disclaimer;
    private String chartName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "bpi",
            joinColumns = @JoinColumn(name = "coin_desk_id"),
            inverseJoinColumns = @JoinColumn(name = "bpi"))
    private BPI bpi;

    public Coindesk() {
    }

    public Coindesk(Time time, String disclaimer, String chartName, BPI bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public BPI getBpi() {
        return bpi;
    }

    public void setBpi(BPI bpi) {
        this.bpi = bpi;
    }

    public Long getId() {
        return coin_desk_id;
    }

    public void setId(Long coin_desk_id) {
        this.coin_desk_id = coin_desk_id;
    }

    @Override
    public String toString() {
        return "Coindesk{" +
                "id=" + coin_desk_id +
                ", time=" + time +
                ", disclaimer='" + disclaimer + '\'' +
                ", chartName='" + chartName + '\'' +
                ", bpi=" + bpi +
                '}';
    }
}
