package {{pkgName}}.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class {{entityClassName}}Dto implements Serializable {
	{{#each fields}}

	private {{this.type}} {{this.name}};
	{{/each}}
}