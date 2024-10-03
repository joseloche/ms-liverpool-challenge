package com.liverpool.challenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "folios")
@Getter
@Setter
public class FolioEntity {

	@Id
	@SequenceGenerator(initialValue = 3, allocationSize = 1, name = "disbursment_sequence", sequenceName = "disbursment_sequence")
	@GeneratedValue(generator = "disbursment_sequence")
	private Long id;
	
	 @Column(name = "folio")
	 private String folio;
	 
	 @Column(name = "digest")
	 private String digest;
}
