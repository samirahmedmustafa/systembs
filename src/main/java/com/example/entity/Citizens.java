package com.example.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizens {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String phoneNo;
	private Date dateOfBirth;
	private String nationalNo;
	private Boolean isDisabled;
	private String skills;
	private Boolean isSupportEligible;
	private Boolean isGainingSupport;
	private Boolean isDeceased;
	private String buildAddressDetails;
	@ManyToOne
	private Location location;
	@ManyToOne
	private School school;
	@ManyToOne
	private Nationality nationality;
	@ManyToOne
	private Qualification qualification;
	@ManyToOne
	private Gender gender;
	@ManyToOne
	private Status status;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_wives", joinColumns = @JoinColumn(name = "husband_id"), inverseJoinColumns = @JoinColumn(name = "wife_id"))
	private Set<Citizens> wives;
		
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_supports", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "supports_id"))
	private Set<Support> supports;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_medicines", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "medicines_id"))
//    @JsonIgnoreProperties("citizens")
	private Set<Medicine> medicines;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_diseases", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "disease_id"))
//    @JsonIgnoreProperties("citizens")
	private Set<Disease> diseases;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_disabilities", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "disability_id"))
//    @JsonIgnoreProperties("citizens")
	private Set<Disability> disabilities;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_professions", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "profession_id"))
//    @JsonIgnoreProperties("citizens")
	private Set<Profession> professions;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "citizens_gases", joinColumns = @JoinColumn(name = "citizen_id"), inverseJoinColumns = @JoinColumn(name = "gas_id"))
//    @JsonIgnoreProperties("citizens")
	private Set<Gas> gases;

}
