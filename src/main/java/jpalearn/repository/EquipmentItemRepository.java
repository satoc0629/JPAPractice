package jpalearn.repository;

import jpalearn.entity.EquipmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "equipmentItems", collectionResourceRel = "equipmentItems")
public interface EquipmentItemRepository extends JpaRepository<EquipmentItem, Integer> {
}
