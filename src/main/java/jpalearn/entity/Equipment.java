package jpalearn.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@NamedEntityGraph(name = "Equipment.allTree", attributeNodes = {@NamedAttributeNode("equipmentItem")})
public class Equipment {
    @Id
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "location")
    private String location;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", updatable = false, insertable = false)
    @OrderBy("id")
    private EquipmentItem equipmentItem;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private User user;
}
