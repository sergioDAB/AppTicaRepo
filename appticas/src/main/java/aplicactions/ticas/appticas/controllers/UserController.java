package aplicactions.ticas.appticas.controllers;

import aplicactions.ticas.appticas.models.ApplicationEntity;
import aplicactions.ticas.appticas.models.UserEntity;
import aplicactions.ticas.appticas.service.ApplicationService;
import aplicactions.ticas.appticas.utils.Response;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    protected ApplicationService applicationService;

    @RequestMapping(value="/login")
    @CrossOrigin(origins = "*")
    public Response getValidUser(@RequestParam("user")String us, @RequestParam("password") String pass) throws SQLException, JSONException {

        UserEntity user= this.applicationService.validateUser(us,pass);
        Response response = new Response(user,"success");

        return  response;
    }
}
