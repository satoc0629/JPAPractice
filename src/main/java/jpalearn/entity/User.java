package jpalearn.entity;


import lombok.Data;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortComparator;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
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

    @OneToMany
    @JoinColumn(name = "user_id")
//    @OrderColumn(name = "id")
//    @OrderBy
//    @RestResource(path = "equipments", rel = "equipments")
    private List<Equipment> equipmentList;
    @OneToMany
    @JoinColumn(name = "user_id")
//    @OrderColumn(name = "id")
//    @OrderBy
//    @RestResource(path = "storages", rel = "storages")
    private List<Storage> storageList;
}
