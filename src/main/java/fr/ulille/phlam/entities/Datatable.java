package fr.ulille.phlam.entities;

import javax.persistence.*;

@Entity
@Table(name = "datatable")
public class Datatable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  private String name;

  @OneToOne
  @JoinColumn(name = "format_id", referencedColumnName = "id")
  private Format format;

  @Column
  private java.sql.Timestamp date;

  @Column
  private String path;

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

  public Format getFormat() {
    return format;
  }

  public void setFormat(Format format) {
    this.format = format;
  }

  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

}
