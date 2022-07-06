package {{pkgName}}.mapper;

import {{pkgName}}.entity.*;
import java.util.List;
import org.mapstruct.*;

@Mapper
public interface {{entityClassName}}Mapper {
	{{entityClassName}}Dto {{entityName}}To{{entityClassName}}Dto({{entityClassName}} {{entityName}}Dto);

	@Mapping(target = "id", ignore = true)
	{{entityClassName}} {{entityName}}DtoTo{{entityClassName}}({{entityClassName}}Dto dto);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "id", ignore = true)
	void update{{entityClassName}}From{{entityClassName}}Dto(
		{{entityClassName}}Dto dto,
        @MappingTarget {{entityClassName}} {{entityName}}
	);

    List<{{entityClassName}}Dto> {{entityName}}IterableTo{{entityClassName}}DtoList(
        Iterable<{{entityClassName}}> {{entityClassName}}Iterable
    );
}