package jpalearn.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_item")
@Data
public class EquipmentItem {

    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "defence")
    private long defence;
    @Column(name = "offence")
    private long offence;
}
