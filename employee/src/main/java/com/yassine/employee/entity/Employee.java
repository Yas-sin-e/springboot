package com.yassine.employee.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private  int   idEmploye;
	  
	  private String nomEmploye;
	  private String prenomEmploye;
	  private String posteEmploye ;
	  private Date dateEmbauche ;
	  private int salaire;
	  private  String  email;
	  private  String  telephone;
	  private  String  adresse;
	  
	  
	  @ManyToOne //plusieur employe a le meme garde
	  @JoinColumn(name = "idGraEmp")
	  private Grade grade ;
	  
	  public Employee() {
		super();
	  }


	  public Employee( String nomEmploye, String prenomEmploye, String posteEmploye, Date dateEmbauche,
			int salaire, String email, String telephone, String adresse, Grade grade) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.posteEmploye = posteEmploye;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.grade = grade;
	}


	  public int getIdEmploye() {
		  return idEmploye;
	  }

	  public void setIdEmploye(int idEmploye) {
		  this.idEmploye = idEmploye;
	  }

	  public String getNomEmploye() {
		  return nomEmploye;
	  }

	  public void setNomEmploye(String nomEmploye) {
		  this.nomEmploye = nomEmploye;
	  }

	  public String getPrenomEmploye() {
		  return prenomEmploye;
	  }

	  public void setPrenomEmploye(String prenomEmploye) {
		  this.prenomEmploye = prenomEmploye;
	  }

	  public String getPosteEmploye() {
		  return posteEmploye;
	  }

	  public void setPosteEmploye(String posteEmploye) {
		  this.posteEmploye = posteEmploye;
	  }

	  public Date getDateEmbauche() {
		  return dateEmbauche;
	  }

	  public void setDateEmbauche(Date dateEmbauche) {
		  this.dateEmbauche = dateEmbauche;
	  }

	  public int getSalaire() {
		  return salaire;
	  }

	  public void setSalaire(int salaire) {
		  this.salaire = salaire;
	  }

	  public String getEmail() {
		  return email;
	  }

	  public void setEmail(String email) {
		  this.email = email;
	  }

	  public String getTelephone() {
		  return telephone;
	  }

	  public void setTelephone(String telephone) {
		  this.telephone = telephone;
	  }

	  public String getAdresse() {
		  return adresse;
	  }

	  public void setAdresse(String adresse) {
		  this.adresse = adresse;
	  }

	  public Grade getGrade() {
		  return grade;
	  }

	  public void setGrade(Grade grade) {
		  this.grade = grade;
	  }

	 

	


	  @Override
	  public String toString() {
		return "Employee [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", prenomEmploye=" + prenomEmploye
				+ ", posteEmploye=" + posteEmploye + ", dateEmbauche=" + dateEmbauche + ", salaire=" + salaire
				+ ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse +"]";
	  }	
	  
	  
	  
}
