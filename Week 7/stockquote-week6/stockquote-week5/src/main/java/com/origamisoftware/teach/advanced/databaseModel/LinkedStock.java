package com.origamisoftware.teach.advanced.databaseModel;

import javax.persistence.*;

/**
 * Models a link between a Person table and a Symbol table.
 */

@Entity
@Table(name = "linkedStocks")
public class LinkedStock {

    private int id;
    private Symbol symbol;
    private Person person;

    /**
     * Create a valid LinkedStock
     *
     * @param person the person to assign the quote to
     * @param symbol  the quote to associate the person with
     */
    public LinkedStock(Person person, Symbol symbol) {
        setSymbol(symbol);
        setPerson(person);
    }

    public LinkedStock() {
    }

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

    /**
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    public Person getPerson() { return person; }

    /**
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return
     */
    @ManyToOne
    @JoinColumn(name = "symbol_id", referencedColumnName = "id", nullable = false)
    public Symbol getSymbol() { return symbol; }

    /**
     * @param symbol
     */
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedStock that = (LinkedStock) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LinkedStock{" +
                "id=" + id +
                ", person=" + person +
                ", quote=" + symbol +
                '}';
    }
}
