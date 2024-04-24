package com.examens.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Examens {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String etudiant;
private Double note;
private Date date;
public Examens() {
super();
}
public Examens(String etudiant, Double note, Date date) {
super();
this.etudiant = etudiant;
this.note = note;
this.date = date;
}

public Long getid() {
return id;
}
public void setid(Long id) {
this.id = id;
}
public String getetudiant() {
return etudiant;
}
public void setetudiant(String etudiant) {
this.etudiant = etudiant;
}
public Double getnote() {
return note;
}
public void setnote(Double note) {
this.note = note;
}
public Date getdate() {
return date;
}
public void setdate(Date date) {
this.date = date;
}
@Override
public String toString() {
return "Examens [id=" + id + ", etudiant=" + 
etudiant + ", note=" + note
+ ", date=" + date + "]";
}
}

