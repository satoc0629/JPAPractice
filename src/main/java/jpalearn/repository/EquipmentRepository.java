package jpalearn.repository;

import jpalearn.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "equipments", collectionResourceRel = "equipments", itemResourceRel = "equipments")
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
}
