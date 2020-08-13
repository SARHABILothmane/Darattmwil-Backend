package com.DarAttamwil.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Simulations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private Boolean civilite;
	private String email;
	private String telephone;
	private String typeClient;
	private String fonction;
	private String autre;
	private float montant;
	private float revenueNet;
	private float autrerevenueNet;
	private float apport;
	private int duree ;
//	private float taux ;
	
    @ManyToOne
    @JoinColumn(name="bank_id", nullable=false)
    private Banks bank;
    @ManyToOne
    @JoinColumn(name="categorie_id", nullable=false)
    private Categories categorie;
    
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date CreatedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getCivilite() {
		return civilite;
	}

	public void setCivilite(Boolean civilite) {
		this.civilite = civilite;
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

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getRevenueNet() {
		return revenueNet;
	}

	public void setRevenueNet(float revenueNet) {
		this.revenueNet = revenueNet;
	}

	public float getAutrerevenueNet() {
		return autrerevenueNet;
	}

	public void setAutrerevenueNet(float autrerevenueNet) {
		this.autrerevenueNet = autrerevenueNet;
	}

	public float getApport() {
		return apport;
	}

	public void setApport(float apport) {
		this.apport = apport;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Banks getBank() {
		return bank;
	}

	public void setBank(Banks bank) {
		this.bank = bank;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Simulations() {
		super();
	}

	public Simulations(int id, String nom, String prenom, Boolean civilite, String email, String telephone,
			String typeClient, String fonction, String autre, float montant, float revenueNet, float autrerevenueNet,
			float apport, int duree, Banks bank, Categories categorie, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.email = email;
		this.telephone = telephone;
		this.typeClient = typeClient;
		this.fonction = fonction;
		this.autre = autre;
		this.montant = montant;
		this.revenueNet = revenueNet;
		this.autrerevenueNet = autrerevenueNet;
		this.apport = apport;
		this.duree = duree;
		this.bank = bank;
		this.categorie = categorie;
		CreatedAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Simulations [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + ", email="
				+ email + ", telephone=" + telephone + ", typeClient=" + typeClient + ", fonction=" + fonction
				+ ", autre=" + autre + ", montant=" + montant + ", revenueNet=" + revenueNet + ", autrerevenueNet="
				+ autrerevenueNet + ", apport=" + apport + ", duree=" + duree + ", bank=" + bank + ", categorie="
				+ categorie + ", CreatedAt=" + CreatedAt + ", updatedAt=" + updatedAt + "]";
	}

  
	
}
