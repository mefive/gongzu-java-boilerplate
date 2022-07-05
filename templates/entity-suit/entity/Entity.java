package {{pkgName}};

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "{{tableName}}")
@Getter
@SuperBuilder
@NoArgsConstructor
public class {{entityClassName}} {
    {{#each fields}}

    {{#each annotations}}
    {{this}}
    {{/each}}
    private {{this.type}} {{this.name}};
    {{/each}}
}