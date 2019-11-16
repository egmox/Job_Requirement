package job.requirement.dto;

import javax.validation.constraints.NotNull;

public class RequirementDto {
	@NotNull
	String jobName;

	@NotNull
	String location;

	@NotNull
	Float experienceRequired;

	@NotNull
	Integer salary;
}
