package jpalearn.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
@Data
@NamedEntityGraph(name = "Equipment.allTree", attributeNodes = {@NamedAttributeNode("equipmentItem")})
public class Equipment implements Serializable {
    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "location")
    private String location;
    @Version
    @Column(name="version")
    private Long version;

    @OneToOne
    @JoinColumn(name = "item_id", updatable = false, insertable = false)
    private EquipmentItem equipmentItem;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id",insertable = false, updatable = false)
//    private User user;
}
