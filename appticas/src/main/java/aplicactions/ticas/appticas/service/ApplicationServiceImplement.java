package aplicactions.ticas.appticas.service;

import aplicactions.ticas.appticas.dao.ApplicationRepository;
import aplicactions.ticas.appticas.models.ApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public abstract class ApplicationServiceImplement implements ApplicationService {

    @Autowired
    protected ApplicationRepository applicationRepository;


    @Override
    public ApplicationEntity save(ApplicationEntity app) {

        return  this.applicationRepository.save(app);
    }
}
