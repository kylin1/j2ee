package edu.nju.onlinestock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kylin on 09/12/2016.
 * All rights reserved.
 */

//The class must be annotated with the javax.persistence.Entity annotation

//The class must not be declared final.
// No methods or persistent instance variables must be declared final
public class Course implements Serializable {

    //If the mapping annotations are applied to the entity’s instance variables,
    // the entity uses persistent fields.
    // The object/relational mapping annotations must be applied to the instance variables.
    private int id;

    //不为持久字段和属性指定@Column注释，将假定到同名字段和属性的数据库列的默认映射
    private String name;

    //The class must have a public or protected, no-argument constructor.
    public Course() {
    }

    //javax.persistence.Id annotation to denote the primary key property or field.
    //If the mapping annotations are applied to the entity’s getter methods
    // for JavaBeans-style properties, the entity uses persistent properties.
    // The object/relational mapping annotations for must be applied to the getter methods.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
