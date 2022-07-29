package hcmute.edu.tgdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  public Nation() {}

  public Nation(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Nation{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
