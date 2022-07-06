package {{pkgName}}.service;

import {{pkgName}}.entity.*;
import {{pkgName}}.dto.*;
import {{pkgName}}.repository.*;
import javax.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class {{entityClassName}}Service {

	private final {{entityClassName}}Repository {{entityName}}Repository;

	private final {{entityClassName}}Mapper {{entityName}}Mapper = Mappers.getMapper({{entityClassName}}Mapper.class);

	public {{entityClassName}}Service({{entityClassName}}Repository {{entityName}}Repository) {
		this.{{entityName}}Repository = {{entityName}}Repository;
	}

	@Transactional
	public {{entityClassName}} save({{entityClassName}}Dto {{entityName}}Dto) {
		{{entityClassName}} {{entityName}} = {{entityName}}Mapper.{{entityName}}DtoTo{{entityClassName}}({{entityName}}Dto);
		{{entityName}}Repository.save({{entityName}});
		return {{entityName}};
	}

	@Transactional
	public {{entityClassName}} update(Integer id, {{entityClassName}}Dto {{entityName}}Dto) throws Exception {
		{{entityClassName}} {{entityName}} = {{entityName}}Repository.findById(id)
            .orElseThrow(() -> new Exception("未找到{{entityNameCh}}"));

        {{entityName}}Mapper.update{{entityClassName}}From{{entityClassName}}Dto({{entityName}}Dto, {{entityName}});
        {{entityName}}Repository.save({{entityName}});

        return {{entityName}};
	}

    @Transactional
    public void remove(Integer id) throws Exception {
		{{entityClassName}} {{entityName}} = {{entityName}}Repository.findById(id)
            .orElseThrow(() -> new Exception("未找到{{entityNameCh}}"));
        {{entityName}}Repository.delete({{entityName}});
    }
}