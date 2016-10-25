package com.origamisoftware.teach.advanced.databaseModel;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Models the Quote table.
 */
@Entity
@Table(name= "quotes")
public class Quote {

    private int id;
    private String symbol;
    private Timestamp time;
    private double price;

    /**
     * Primary Key - Unique ID for a particular row in the hobby table.
     *
     * @return an integer value
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the hobby table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Basic
    @Column(name = "symbol", nullable = false)
    public String getSymbol() { return symbol; }

    /**
     * @param symbol
     */
    public void setSymbol(String symbol) { this.symbol = symbol; }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() { return time; }

    public void setTime(Timestamp time) { this.time = time; }

    @Basic
    @Column(name = "price", precision = 10, scale = 3, nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (id == quote.id) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + symbol.hashCode();
        result = 31 * result + time.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
