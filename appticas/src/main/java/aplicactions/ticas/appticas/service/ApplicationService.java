package aplicactions.ticas.appticas.service;

import aplicactions.ticas.appticas.dao.ApplicationRepository;
import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    protected ApplicationRepository applicationRepository;


    public Response saveApplication(ApplicationEntity app) {

        return this.applicationRepository.saveApplications(app);
    }

    public List<ApplicationEntity> getAllApplications() throws SQLException {

        return this.applicationRepository.getAllApps();
    }
}
