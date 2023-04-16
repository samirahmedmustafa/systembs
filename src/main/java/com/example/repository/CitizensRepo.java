package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Citizens;

public interface CitizensRepo extends JpaRepository<Citizens, Long>{

	@Query(nativeQuery = true, value = "SELECT"
			+ "	citizens.id,citizens.name,build_address_details,date_of_birth,is_deceased,is_disabled,is_gaining_support,"
			+ "	is_support_eligible,national_no, phone_no, skills,gender.name gender,location.number location_number,nationality.name nationality,"
			+ "	qualification.name qualification,school.name school,count(distinct citizens_gases.gas_id) gasCount,"
			+ "	count(distinct citizens_medicines.medicines_id) medicineCount,count(distinct citizens_diseases.disease_id) diseaseCount,"
			+ "	count(distinct citizens_professions.profession_id) professionCount,"
			+ "	count(distinct citizens_disabilities.disability_id) disabilitiesCount,"
			+ "	count(distinct citizens_supports.supports_id) supportsCount"
			+ " FROM citizens"
			+ "	left outer join citizens_gases on citizens.id=citizens_gases.citizen_id"
			+ "	left outer join citizens_medicines on citizens.id=citizens_medicines.citizen_id"
			+ "	left outer join citizens_diseases on citizens.id=citizens_diseases.citizen_id"
			+ "	left outer join citizens_professions on citizens.id=citizens_professions.citizen_id"
			+ "	left outer join citizens_disabilities on citizens.id=citizens_disabilities.citizen_id"
			+ "	left outer join citizens_supports on citizens.id=citizens_supports.citizen_id"
			+ "	left outer join gender on citizens.gender_id=gender.id"
			+ "	left outer join location on citizens.location_id=location.id"
			+ "	left outer join nationality on citizens.nationality_id=nationality.id"
			+ "	left outer join qualification on citizens.qualification_id=qualification.id"
			+ "	left outer join school on citizens.school_id=school.id"
			+ " group by"
			+ "	citizens.id,gender.name,location.number,nationality.name,qualification.name,school.name")
	List<Object[]> findCitizensByGasCount();

}
