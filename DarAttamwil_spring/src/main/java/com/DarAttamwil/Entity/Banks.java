package com.DarAttamwil.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Banks {
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String nom;
	    private float taux;
	    private float apport;
	    
//	    @OneToMany(mappedBy="bank",cascade = CascadeType.ALL,orphanRemoval = true)
	    @OneToMany(mappedBy="bank")
	    @JsonIgnore
	    private List<Financements> financement;
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
		public float getTaux() {
			return taux;
		}
		public void setTaux(float taux) {
			this.taux = taux;
		}
		public float getApport() {
			return apport;
		}
		public void setApport(float apport) {
			this.apport = apport;
		}
		public List<Financements> getFinancement() {
			return financement;
		}
		public void setFinancement(List<Financements> financement) {
			this.financement = financement;
		}
		public Banks() {
			super();
		}
		public Banks(int id, String nom, float taux, float apport, List<Financements> financement) {
			super();
			this.id = id;
			this.nom = nom;
			this.taux = taux;
			this.apport = apport;
			this.financement = financement;
		}
		@Override
		public String toString() {
			return "Banks [id=" + id + ", nom=" + nom + ", taux=" + taux + ", apport=" + apport + ", financement="
					+ financement + "]";
		}
    
}

