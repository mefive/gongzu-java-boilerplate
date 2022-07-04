package {{pkgName}};

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "{{tableName}}")
@Getter
@SuperBuilder
@NoArgsConstructor
public class {{entityClass}} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    {{#each fileds}}
    private {{this.type}} {{this.name}};

    {{/each}}
}