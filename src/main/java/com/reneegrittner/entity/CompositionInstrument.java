package com.reneegrittner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;
@Entity(name = "CompositionInstrument")
@Table(name = "Composition_Instrument")
@XmlAccessorType( XmlAccessType.FIELD)
public class CompositionInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "player")
    private int playerNumber;

    @Column(name = "qty")
    private int instumentQuantity;

    @ManyToOne
    //@XmlTransient
    private Instrument instrument;

    @ManyToOne
    //@XmlTransient
    private Composition composition;

    public CompositionInstrument() {
    }

    public CompositionInstrument(int playerNumber, int instumentQuantity, Instrument instrument, Composition composition) {
        this.playerNumber = playerNumber;
        this.instumentQuantity = instumentQuantity;
        this.instrument = instrument;
        this.composition = composition;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getInstumentQuantity() {
        return instumentQuantity;
    }

    public void setInstumentQuantity(int instumentQuantity) {
        this.instumentQuantity = instumentQuantity;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }



    @Override
    public String toString() {
        return "CompositionInstrument{" +
                "id=" + id +
                ", playerNumber=" + playerNumber +
                ", instumentQuantity=" + instumentQuantity +
                ", instrument=" + instrument +
                ", composition=" + composition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionInstrument that = (CompositionInstrument) o;
        return id == that.id &&
                playerNumber == that.playerNumber &&
                instumentQuantity == that.instumentQuantity &&
                Objects.equals(instrument, that.instrument) &&
                Objects.equals(composition, that.composition);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, playerNumber, instumentQuantity, instrument, composition);
    }
}
