package com.origamisoftware.teach.advanced.databaseModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Models the Symbol table.
 */

@Entity
@Table(name = "symbol")
public class Symbol {

    private int id;
    private String symbol;

    /**
     * Primary Key - Unique ID for a particular row in the person table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stock_symbol", nullable = false)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
