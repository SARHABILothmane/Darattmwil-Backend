package com.DarAttamwil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Roles {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String label;
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
		
		public Roles() {
			super();
		}
		
		public Roles(int id, String label) {
			super();
			this.id = id;
			this.label = label;
		}
		@Override
		public String toString() {
			return "Roles [id=" + id + ", label=" + label + "]";
		}
	    
}
