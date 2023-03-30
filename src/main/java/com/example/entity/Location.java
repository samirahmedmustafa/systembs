package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String number;
	private String blkNo;
	private String ownerID;
	private String ownerName;
	private String ownerPhoneNo;
	private String delegateId;
	private String delegateName;
	private String delegatePhoneNo;
	@OneToMany(mappedBy = "location")
	private List<Citizens> citizens;
}
