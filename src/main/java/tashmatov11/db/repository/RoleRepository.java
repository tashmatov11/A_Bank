package tashmatov11.db.repository;

import tashmatov11.db.models.enums.ERole;
import tashmatov11.db.models.userClasses.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
