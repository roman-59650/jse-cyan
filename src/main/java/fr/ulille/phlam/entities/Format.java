package fr.ulille.phlam.entities;

import javax.persistence.*;

@Entity
@Table(name = "format")
public class Format {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "qn_format")
  private String qnFormat;
  @Column(name = "qn_count")
  private long qnCount;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQnFormat() {
    return qnFormat;
  }

  public void setQnFormat(String qnFormat) {
    this.qnFormat = qnFormat;
  }

  public long getQnCount() {
    return qnCount;
  }

  public void setQnCount(long qnCount) {
    this.qnCount = qnCount;
  }

}
