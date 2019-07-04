package project.with.add.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.with.add.data.entity.FormEntity;
@Repository
public interface FormEntityRepository extends JpaRepository<FormEntity, Integer>, JpaSpecificationExecutor<FormEntity>{
//@Query("select f from Fromentity f where f.name = :name")
//FormEntity findByName(@Param("name")String name);
}
