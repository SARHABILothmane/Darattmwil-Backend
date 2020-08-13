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
public class Status {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String label;
//	    @ManyToOne
//	    @JoinColumn(name="financement_id", nullable=false)
//	    private Financements financement;
	    
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

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
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

		public Status() {
			super();
		}

		public Status(int id, String label, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.label = label;
			CreatedAt = createdAt;
			this.updatedAt = updatedAt;
		}

		@Override
		public String toString() {
			return "Status [id=" + id + ", label=" + label + ", CreatedAt=" + CreatedAt + ", updatedAt=" + updatedAt
					+ "]";
		}



}
