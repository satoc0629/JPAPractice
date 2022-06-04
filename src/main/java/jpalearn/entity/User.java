package jpalearn.entity;


import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

@Entity
@Table(name = "\"user\"")
@Data
//@NamedEntityGraph(name = "User.allTree", attributeNodes = {@NamedAttributeNode(value = "equipmentList", subgraph = "equipmentList.allTree"), @NamedAttributeNode("storageList")},
//        subgraphs = {@NamedSubgraph(name = "equipmentList.allTree", attributeNodes = {@NamedAttributeNode("equipmentItem")})})
public class User {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_equipment_user"), nullable = false, insertable = false, updatable = false)
    @OrderColumn(name = "id", insertable = false, updatable = false)
    @OrderBy
//    @RestResource(path = "equipments", rel = "equipments")
    private List<Equipment> equipmentList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_storage_user"), nullable = false, insertable = false, updatable = false)
    @OrderColumn(name = "id", updatable = false, insertable = false)
    @OrderBy
//    @RestResource(path = "storages", rel = "storages")
    private List<Storage> storageList;
}
