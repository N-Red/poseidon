package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curvepoint_sequence")
    @SequenceGenerator(name = "curvepoint_sequence")
    private Integer id;
    @NotNull(message = "must be not null")
    private Integer curvePointId;
    private Date asOfDate;
    private double term;
    private double value;
    private Date creationDate;

    public CurvePoint() {
    }

    public CurvePoint(int curvePointId, double term, double value) {
        this.curvePointId = curvePointId;
        this.term = term;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurvePointId() {
        return curvePointId;
    }

    public void setCurvePointId(Integer curvePointId) {
        this.curvePointId = curvePointId;
    }

    public Date getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(Date asOfDate) {
        this.asOfDate = asOfDate;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
