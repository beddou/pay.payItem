package com.pay.payitem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueChapter", columnNames = { "organism", "design" }) })
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Name cannot be null") @NotEmpty @NotBlank
    private String design;
    
    private String description;

    @Column(columnDefinition = "boolean default true")
    private boolean systemCreated;

    @Min(value = 1, message = "organism must be input")
    private int organism;

    

    public Chapter( @NotNull(message = "Name cannot be null") @NotEmpty @NotBlank String design,
            String description, boolean systemCreated,
            @Min(value = 1, message = "organism must be input") int organism) {
        
        this.design = design;
        this.description = description;
        this.systemCreated = systemCreated;
        this.organism = organism;
    }

    public Chapter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSystemCreated() {
        return systemCreated;
    }

    public void setSystemCreated(boolean systemCreated) {
        this.systemCreated = systemCreated;
    }

    public int getOrganism() {
        return organism;
    }

    public void setOrganism(int organism) {
        this.organism = organism;
    }

    


    
}
