package {{pkgName}}.controller;

import {{pkgName}}.entity.*;
import {{pkgName}}.dto.*;
import {{pkgName}}.mapper.*;
import {{pkgName}}.repository.*;
import {{pkgName}}.service.*;
import cn.rigongyi.gongzu.core.query.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("{{entityNamePlural}}")
public class {{entityClassName}}Controller {

	@PersistenceContext
	private EntityManager entityManager;

	private final {{entityClassName}}Repository {{entityName}}Repository;

	private final {{entityClassName}}Service {{entityName}}Service;

	private final {{entityClassName}}Mapper {{entityName}}Mapper = Mappers.getMapper({{entityClassName}}Mapper.class);

	public {{entityClassName}}Controller(
		{{entityClassName}}Repository {{entityName}}Repository,
		{{entityClassName}}Service {{entityName}}Service
	) {
		this.{{entityName}}Repository = {{entityName}}Repository;
		this.{{entityName}}Service = {{entityName}}Service;
	}

	@GetMapping
	List<{{entityClassName}}Dto> list() {
		Iterable<{{entityClassName}}> {{entityNamePlural}} = {{entityName}}Repository.findAll();
		return {{entityName}}Mapper.{{entityName}}IterableTo{{entityClassName}}DtoList({{entityNamePlural}});
	}

	@GetMapping("query")
	List<{{entityClassName}}Dto> query(QueryRequest queryRequest) throws Exception {
		var spec = new QuerySpecifications<>(
                entityManager.getCriteriaBuilder().createQuery({{entityClassName}}.class).from({{entityClassName}}.class),
                queryRequest
        );
        Iterable<{{entityClassName}}> {{entityNamePlural}} = {{entityName}}Repository.findAll(spec.getSpecification());
        return {{entityName}}Mapper.{{entityName}}IterableTo{{entityClassName}}DtoList({{entityNamePlural}});
	}

    @GetMapping("query-page")
	Page<{{entityClassName}}Dto> queryPage(QueryRequest queryRequest, Pageable pageable) throws Exception {
        var spec = new QuerySpecifications<>(
                entityManager.getCriteriaBuilder().createQuery({{entityClassName}}.class).from({{entityClassName}}.class),
                queryRequest
        );
        Page<{{entityClassName}}> {{entityNamePlural}} = {{entityName}}Repository.findAll(spec.getSpecification(), pageable);
        return {{entityNamePlural}}.map({{entityName}}Mapper::{{entityName}}To{{entityClassName}}Dto);
	}

    @PostMapping
    {{entityClassName}}Dto save(@RequestBody @Valid {{entityClassName}}Dto {{entityName}}Dto) {
        {{entityClassName}} {{entityName}} = {{entityName}}Service.save({{entityName}}Dto);
        return {{entityName}}Mapper.{{entityName}}To{{entityClassName}}Dto({{entityName}});
    }

    @PutMapping("{id}")
    {{entityClassName}}Dto update(
        @PathVariable Integer id, 
        @RequestBody @Valid {{entityClassName}}Dto {{entityName}}Dto
    ) throws Exception {
        {{entityClassName}} {{entityName}} = {{entityName}}Service.update(id, {{entityName}}Dto);
        return {{entityName}}Mapper.{{entityName}}To{{entityClassName}}Dto({{entityName}});
    }

    @DeleteMapping("{id}")
    void remove(@PathVariable Integer id) throws Exception {
        {{entityName}}Service.remove(id);
    }
}