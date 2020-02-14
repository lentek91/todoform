package pl.github.lentek.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TODO")
@Data
public class Todo {

  @Id
  @GeneratedValue(generator = "inc")
  @GenericGenerator(name = "inc", strategy = "increment")
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TEXT")
  private String text;

  @Column(name = "DONE")
  private Boolean done;
}
