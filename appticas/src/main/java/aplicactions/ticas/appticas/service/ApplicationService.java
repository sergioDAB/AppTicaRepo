package aplicactions.ticas.appticas.service;

import aplicactions.ticas.appticas.dao.ApplicationRepository;
import aplicactions.ticas.appticas.dao.UserRepository;
import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.models.UserEntity;
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

    @Autowired
    UserRepository userRepository;


    public Response saveApplication(ApplicationEntity app) {

        return this.applicationRepository.saveApplications(app);
    }

    public List<ApplicationEntity> getAllApplications() throws SQLException {

        return this.applicationRepository.getAllApps();
    }

    public UserEntity validateUser(String user,String password) throws SQLException {
        return  this.userRepository.logIn(user,password);
    }

    public String setCalification(String puntos,String id_app, String id_usu) throws SQLException {
        return  this.applicationRepository.AppCalification(puntos,id_app,id_usu);
    }
}
