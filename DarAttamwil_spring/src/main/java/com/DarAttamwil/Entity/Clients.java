package com.DarAttamwil.Entity;


import java.util.Date;

import javax.persistence.Entity;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Clients extends Utilisateur{
	private String adresse;
	private int age;
	private String telephone;
	private String fonction;
	private String typeDeBesion;
	private float revenueNet;
	private float autreRevenue;
	private float chargeLocative;
    //@ToString.Exclude
    @ManyToOne
    @JoinColumn(name="ville_id", nullable=false)
    private Villes ville;
    
    @ManyToOne
    @JoinColumn(name="financement_id", nullable=false)
    private Financements financement;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}



	public String getTypeDeBesion() {
		return typeDeBesion;
	}

	public void setTypeDeBesion(String typeDeBesion) {
		this.typeDeBesion = typeDeBesion;
	}

	public float getRevenueNet() {
		return revenueNet;
	}

	public void setRevenueNet(float revenueNet) {
		this.revenueNet = revenueNet;
	}

	public float getAutreRevenue() {
		return autreRevenue;
	}

	public void setAutreRevenue(float autreRevenue) {
		this.autreRevenue = autreRevenue;
	}

	public float getChargeLocative() {
		return chargeLocative;
	}

	public void setChargeLocative(float chargeLocative) {
		this.chargeLocative = chargeLocative;
	}


	public Villes getVille() {
		return ville;
	}

	public void setVille(Villes ville) {
		this.ville = ville;
	}

	public Financements getFinancement() {
		return financement;
	}

	public void setFinancement(Financements financement) {
		this.financement = financement;
	}



	public Clients() {
		super();
	}



	public Clients(String adresse, int age, String telephone, String fonction, String typeDeBesion, float revenueNet,
			float autreRevenue, float chargeLocative, Villes ville, Financements financement) {
		super();
		this.adresse = adresse;
		this.age = age;
		this.telephone = telephone;
		this.fonction = fonction;
		this.typeDeBesion = typeDeBesion;
		this.revenueNet = revenueNet;
		this.autreRevenue = autreRevenue;
		this.chargeLocative = chargeLocative;
		this.ville = ville;
		this.financement = financement;
	}

	public Clients(int id, String nom, String prenom, Roles role, String email, String password, String name,
			String type, byte[] picByte, Date createdAt, Date updatedAt,String adresse, int age, String telephone, String fonction, String typeDeBesion, float revenueNet,
			float autreRevenue, float chargeLocative, Villes ville, Financements financement) {
		super(id, nom, prenom, role, email, password, name, type, picByte, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
		this.adresse = adresse;
		this.age = age;
		this.telephone = telephone;
		this.fonction = fonction;
		this.typeDeBesion = typeDeBesion;
		this.revenueNet = revenueNet;
		this.autreRevenue = autreRevenue;
		this.chargeLocative = chargeLocative;
		this.ville = ville;
		this.financement = financement;
		
	}

	@Override
	public String toString() {
		return "Clients [adresse=" + adresse + ", age=" + age + ", telephone=" + telephone + ", fonction=" + fonction
				+ ", typeDeBesion=" + typeDeBesion + ", revenueNet=" + revenueNet + ", autreRevenue=" + autreRevenue
				+ ", chargeLocative=" + chargeLocative + ", ville=" + ville + ", financement=" + financement + "]";
	}



   
}
