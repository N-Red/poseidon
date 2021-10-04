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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int curveId;
    private Date asOfDate;
    private double term;
    private double value;
    private Date creationDate;

    public CurvePoint() {
    }

    public CurvePoint(int i, double v, double v1) {
        this.curveId = i;
        this.term = v;
        this.value = v1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCurveId() {
        return curveId;
    }

    public void setCurveId(int curveId) {
        this.curveId = curveId;
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
