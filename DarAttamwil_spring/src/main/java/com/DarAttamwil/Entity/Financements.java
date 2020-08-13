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
public class Financements {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private float montant;
	    private String office;
	    private int duree;
	    @ManyToOne
	    @JoinColumn(name="bank_id", nullable=false)
	    private Banks bank;
	    @ManyToOne
	    @JoinColumn(name="categorie_id", nullable=false)
	    private Categories categorie;
	    
	    @ManyToOne
	    @JoinColumn(name="statut_id", nullable=false)
	    private Status statut;
	    
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

		public float getMontant() {
			return montant;
		}

		public void setMontant(float montant) {
			this.montant = montant;
		}

		public String getOffice() {
			return office;
		}

		public void setOffice(String office) {
			this.office = office;
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

		public Status getStatut() {
			return statut;
		}

		public void setStatut(Status statut) {
			this.statut = statut;
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

		public Financements() {
			super();
		}

		public Financements(int id, float montant, String office, int duree, Banks bank, Categories categorie,
				Status statut, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.montant = montant;
			this.office = office;
			this.duree = duree;
			this.bank = bank;
			this.categorie = categorie;
			this.statut = statut;
			CreatedAt = createdAt;
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "Financements [id=" + id + ", montant=" + montant + ", office=" + office + ", duree=" + duree
					+ ", bank=" + bank + ", categorie=" + categorie + ", statut=" + statut + ", CreatedAt=" + CreatedAt
					+ ", updatedAt=" + updatedAt + "]";
		}

	

		
	    
}
