package hcmute.edu.tgdd.model;

import javax.persistence.*;

@Entity
public class Nation {
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

  public Nation() {}

  public Nation(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Nation{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
