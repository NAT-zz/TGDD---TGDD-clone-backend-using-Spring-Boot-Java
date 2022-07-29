package hcmute.edu.tgdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kind {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(nullable = false, unique = true)
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Kind() {}

  public Kind(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Kind{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
