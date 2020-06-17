package org.jonas.jontability.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity implements BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
