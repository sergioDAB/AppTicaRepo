package aplicactions.ticas.appticas.controllers;

import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.service.ApplicationService;
import aplicactions.ticas.appticas.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class ApplicationController {

    @Autowired
    protected ApplicationService applicationService;

    protected ObjectMapper objectMapper;

    @RequestMapping(value="/apps")
    public List<ApplicationEntity> getApplications(){
        Response response = new Response(200,"success");

        List<ApplicationEntity> apps= this.applicationService.getAllApplications();
        ApplicationEntity ap1= apps.get(0);

        return  apps;
    }

    @RequestMapping(value = "/saveUpdate", method= RequestMethod.POST)
    public Response saveUpdate(@RequestBody String json) throws IOException {
        this.objectMapper = new ObjectMapper();
        ApplicationEntity app = this.objectMapper.readValue(json,ApplicationEntity.class);

        if(!this.isValid(app)){
            return new Response(HttpStatus.NOT_ACCEPTABLE.value(),"falta el indicador");
        }
        this.applicationService.saveApplication(app);
        return new Response(HttpStatus.OK.value(),"success");
    }

    private boolean isValid(ApplicationEntity app){
        return app.getIdApp() != null;
    }

}
