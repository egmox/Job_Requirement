package job.requirement.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "requirement")
@Data
public class Requirement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "job_name")
	String jobName;

	@Column(name = "location")
	String location;

	@Column(name = "experience_required")
	Float experienceRequired;

	@Column(name = "salary")
	Integer salary;

	@ManyToMany
	@JoinTable(name = "requirement_profile_map", joinColumns = {
			@JoinColumn(name = "requirement_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "profile_id", nullable = false) })
	@JsonIgnore
	@Cascade({CascadeType.ALL})
	List<Profile> profile = new ArrayList<>();
}
