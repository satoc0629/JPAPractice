package jpalearn.repository;

import jpalearn.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "storages", collectionResourceRel = "storages")
public interface StorageRepository extends JpaRepository<Storage, Integer> {
}
