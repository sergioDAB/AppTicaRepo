package aplicactions.ticas.appticas.controllers;

import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.service.ApplicationService;
import aplicactions.ticas.appticas.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@RestController
public class ApplicationController {

    @Autowired
    protected ApplicationService applicationService;

    protected ObjectMapper objectMapper;

    @RequestMapping(value="/apps")
    @CrossOrigin(origins = "*")
    public Response getApplications() throws SQLException, JSONException {

        List<ApplicationEntity> apps= this.applicationService.getAllApplications();
        Response response = new Response(apps,"success");

        return  response;
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
