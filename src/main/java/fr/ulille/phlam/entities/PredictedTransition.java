package fr.ulille.phlam.entities;

import javax.persistence.*;

@Entity
@Table(name = "predicted_transition")
public class PredictedTransition {

  private short qn21;
  private short qn22;
  private short qn23;
  private double qn24;
  private double qn25;
  private double qn26;
  private short qn11;
  private short qn12;
  private short qn13;
  private double qn14;
  private double qn15;
  private double qn16;
  private double frequency;
  private double intensity;
  private long tableId;
  private long compId;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long pid;

  public short getQn21() {
    return qn21;
  }

  public void setQn21(short qn21) {
    this.qn21 = qn21;
  }

  public short getQn22() {
    return qn22;
  }

  public void setQn22(short qn22) {
    this.qn22 = qn22;
  }

  public short getQn23() {
    return qn23;
  }

  public void setQn23(short qn23) {
    this.qn23 = qn23;
  }

  public double getQn24() {
    return qn24;
  }

  public void setQn24(double qn24) {
    this.qn24 = qn24;
  }

  public double getQn25() {
    return qn25;
  }

  public void setQn25(double qn25) {
    this.qn25 = qn25;
  }

  public double getQn26() {
    return qn26;
  }

  public void setQn26(double qn26) {
    this.qn26 = qn26;
  }

  public short getQn11() {
    return qn11;
  }

  public void setQn11(short qn11) {
    this.qn11 = qn11;
  }

  public short getQn12() {
    return qn12;
  }

  public void setQn12(short qn12) {
    this.qn12 = qn12;
  }

  public short getQn13() {
    return qn13;
  }

  public void setQn13(short qn13) {
    this.qn13 = qn13;
  }

  public double getQn14() {
    return qn14;
  }

  public void setQn14(double qn14) {
    this.qn14 = qn14;
  }

  public double getQn15() {
    return qn15;
  }

  public void setQn15(double qn15) {
    this.qn15 = qn15;
  }

  public double getQn16() {
    return qn16;
  }

  public void setQn16(double qn16) {
    this.qn16 = qn16;
  }

  public double getFrequency() {
    return frequency;
  }

  public void setFrequency(double frequency) {
    this.frequency = frequency;
  }

  public double getIntensity() {
    return intensity;
  }

  public void setIntensity(double intensity) {
    this.intensity = intensity;
  }

  public long getTableId() {
    return tableId;
  }

  public void setTableId(long tableId) {
    this.tableId = tableId;
  }

  public long getCompId() {
    return compId;
  }

  public void setCompId(long compId) {
    this.compId = compId;
  }

  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

}
