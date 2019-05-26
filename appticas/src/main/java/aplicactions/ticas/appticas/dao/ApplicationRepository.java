package aplicactions.ticas.appticas.dao;

import aplicactions.ticas.appticas.models.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {
    @SuppressWarnings("Unchecked")
    ApplicationEntity save(ApplicationEntity app);
}


//JpaRepository<ApplicationEntity, Long>