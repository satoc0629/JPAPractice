package jpalearn.repository;

import jpalearn.entity.Equipment;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "equipments", collectionResourceRel = "equipments", itemResourceRel = "equipments")
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    @Override
    @Lock(LockModeType.OPTIMISTIC)
    Optional<Equipment> findById(Integer integer);
}
