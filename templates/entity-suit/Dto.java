package {{pkgName}}.dto;

@Data
public class {{entityClassName}}Dto implements Serializable {

	{{#each fields}}

	private {{this.type}} {{this.name}};
	{{/each}}
}