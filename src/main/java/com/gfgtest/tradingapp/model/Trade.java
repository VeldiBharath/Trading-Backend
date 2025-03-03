package com.gfgtest.tradingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@Entity //represents this is a schema/entity
@Table(name = "trades") //table name
//@Data  //only generates getter and setter methods for fields that are not marked final.
// Ensure that id is not final, because if it is, Lombok will not generate a setter for it.
//@Getter
//@Setter  // id should not be final hence individually call getter and setter
//@NoArgsConstructor //automatically generates constructors without arguments
//@AllArgsConstructor //automatically generates constructors with arguments

public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //no setter implementation for id
    @Column(nullable = false)
    private String type;

    public Long getId() {
        return id;
    }

    @Version
    private Integer version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String symbol;
    @Column(nullable = false)
    private Long shares;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private Instant timestamp;




}
