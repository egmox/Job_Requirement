package job.requirement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import job.requirement.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
	Optional<Requirement> findById(Long id);
}
