package pl.github.lentek.lang;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LANGUAGE")
public class Lang {

  @Id
  @GeneratedValue(generator = "inc")
  @GenericGenerator(name = "inc", strategy = "increment")
  @Column(name = "ID")
  private Integer id;

  @Column(name = "WELCOME_MESSAGE")
  private String welcomeMessage;

  @Column(name = "CODE")
  private String code;
}
