package job.requirement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "profile")
@Data
public class Profile implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Long id;

	@Column(name = "candidate_name")
	String candidateName;

	@Column(name = "phone")
	String phone;

	@Column(name = "email")
	String email;
}
