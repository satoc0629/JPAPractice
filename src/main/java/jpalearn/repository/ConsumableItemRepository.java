package jpalearn.repository;

import jpalearn.entity.ConsumableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "consumableItems", collectionResourceRel = "consumableItems")
public interface ConsumableItemRepository extends JpaRepository<ConsumableItem, Integer> {
}
