package jpalearn.repository;

import jpalearn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u from User u join fetch u.equipmentList join fetch u.storageList")
    List<User> find1Hierarchie();

    @Query(value = "select u from User u join fetch u.equipmentList e join fetch e.equipmentItem join fetch u.storageList")
    List<User> find2Hierarchie();

}
