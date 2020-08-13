package com.DarAttamwil.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categories {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String label;
	    @OneToMany(mappedBy="bank")
	    @JsonIgnore
	    private List<Financements> financement;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public List<Financements> getFinancement() {
			return financement;
		}
		public void setFinancement(List<Financements> financement) {
			this.financement = financement;
		}
		public Categories() {
			super();
		}
		public Categories(int id, String label, List<Financements> financement) {
			super();
			this.id = id;
			this.label = label;
			this.financement = financement;
		}
		@Override
		public String toString() {
			return "Categories [id=" + id + ", label=" + label + ", financement=" + financement + "]";
		}

}
