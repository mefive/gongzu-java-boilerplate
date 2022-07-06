package {{pkgName}}.repository;

import {{pkgName}}.entity.*;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface {{entityClassName}}Repository extends CrudRepository<{{entityClassName}}, Integer>, JpaSpecificationExecutor<{{entityClassName}}> {

}