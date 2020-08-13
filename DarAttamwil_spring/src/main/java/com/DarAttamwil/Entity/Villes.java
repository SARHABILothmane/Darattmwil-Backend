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
public class Villes {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String label;
//	    @OneToMany(mappedBy="ville",cascade = CascadeType.ALL,orphanRemoval = true)
	    @OneToMany(mappedBy="ville")
	    @JsonIgnore
	    private List<Clients> client;
	    
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
		public List<Clients> getClient() {
			return client;
		}
		public void setClient(List<Clients> client) {
			this.client = client;
		}
		public Villes() {
			super();
		}
		public Villes(int id, String label, List<Clients> client) {
			super();
			this.id = id;
			this.label = label;
			this.client = client;
		}
		@Override
		public String toString() {
			return "Villes [id=" + id + ", label=" + label + ", client=" + client + "]";
		}
		
		
}
