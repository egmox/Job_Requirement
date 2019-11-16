package job.requirement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import job.requirement.entity.Profile;
import job.requirement.entity.Requirement;
import job.requirement.repository.RequirementRepository;

@RestController
public class Controller {

	@Autowired
	RequirementRepository repo;

	
	//This creates the job
	@PostMapping("/create_job")
	public String createJob(@RequestBody Requirement requirement) {
		Requirement req = repo.save(requirement);
		if (req != null)
			return ("Requirement created with ID: " + req.getId());
		return "Requirement not created";
	}

	//This provides list of jobs
	@PostMapping("/getJobs")
	public List<Requirement> requirements() {
		return repo.findAll();
	}

	//On UI end, on click of a job, it opens page ...job/id
	//Then, user uploads his/her profile on ...job/id page
	@PostMapping("/uploadProfile")
	public String uploadRequirement(@RequestParam("id") Long id, @RequestBody Profile profile) {
		Requirement req = repo.findById(id).get();
		List<Profile> profiles = new ArrayList<Profile>();
		profiles.add(profile);
		req.setProfile(profiles);
		if (repo.save(req) != null)
			return "saved";
		return "not saved";
	}

	//This gets you list of job profiles for a specific job
	@PostMapping("/getProfiles")
	public List<Profile> getProfiles(@RequestParam("jobId") Long id) {
		Requirement req = repo.findById(id).get();
		return req.getProfile();
	}
}
