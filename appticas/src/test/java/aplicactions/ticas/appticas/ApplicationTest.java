package aplicactions.ticas.appticas;

import aplicactions.ticas.appticas.controllers.ApplicationController;
import aplicactions.ticas.appticas.dao.ApplicationRepository;
import aplicactions.ticas.appticas.models.ApplicationEntity;
import org.junit.Assert.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Fail.fail;


public class ApplicationTest {

    /*
    * casos de prueba para getAllAppsTest-----------------------------------------------
    * */

    /*01
    * hay 1 aplicacion
    * */
    @Test
    public void getAllAppsTest1() throws SQLException {
        String resultado = ApplicationRepository.getAllApps().toString();
        ApplicationEntity app = new ApplicationEntity(1,"UBER",1,1,"vehicular","vacio");
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();
        esperado.add(app);

        assertEquals(resultado,esperado.toString());

    }

    /*02
     * no hay aplicaciones en la base de datos
     * */
    @Test
    public void getAllAppsTest2() throws SQLException {
        String resultado = ApplicationRepository.getAllApps().toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());

    }

    //casos de prueba para getAppById-----------------------------------------------


    /*03
    ingresa un id existente en la base de datos
    */

    @Test
    public void getAppByIdTest1() throws SQLException {
        String resultado = ApplicationRepository.getAppById("1").toString();
        ApplicationEntity app = new ApplicationEntity(1,"UBER",1,1,"vehicular","vacio");
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();
        esperado.add(app);

        assertEquals(resultado,esperado.toString());
    }

    /*04
    ingresa un id no existente en la base de datos
    */

    @Test
    public void getAppByIdTest2() throws SQLException {
        String resultado = ApplicationRepository.getAppById("2").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());

    }

    /*05
    ingresa una letra en el espacio del id
    */

    @Test
    public void getAppByIdTest3() throws SQLException {
        String resultado = ApplicationRepository.getAppById("a").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*06
    ingresa un espacio vacio "" en el id
    */

    @Test
    public void getAppByIdTest4() throws SQLException {
        String resultado = ApplicationRepository.getAppById(" ").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*
    * casos de prueba para la busqueda de aplicaciones por desarrollador
    * */

    /*07
    * existe el desarrollador en la base de datos
    * */
    @Test
    public void getAppByDeveloper1() throws SQLException {
        String resultado = ApplicationRepository.getAppByDev("1").toString();
        ApplicationEntity app = new ApplicationEntity(1,"UBER",1,1,"vehicular","vacio");
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();
        esperado.add(app);

        assertEquals(resultado,esperado.toString());
    }

    /*08
     * no existe el desarrollador en la base de datos
     * */
    @Test
    public void getAppByDeveloper2() throws SQLException {
        String resultado = ApplicationRepository.getAppByDev("2").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*09
     * ingresando un indentificador del tipo de dato incorrecto
     * */
    @Test
    public void getAppByDeveloper3() throws SQLException {
        String resultado = ApplicationRepository.getAppByDev("n").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*10
     * ingresando un indentificador vacio
     * */
    @Test
    public void getAppByDeveloper4() throws SQLException {
        String resultado = ApplicationRepository.getAppByDev(" ").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*
     * casos de prueba para la busqueda de aplicaciones por categoria
     * */

    /*11
     * existe la categoria id 1  en la base de datos
     * */
    @Test
    public void getAppByCategory1() throws SQLException {
        String resultado = ApplicationRepository.getAppByCategory("1").toString();
        ApplicationEntity app = new ApplicationEntity(1,"UBER",1,1,"vehicular","vacio");
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();
        esperado.add(app);

        assertEquals(resultado,esperado.toString());
    }

    /*12
     * no existe la categoria id 2 en la base de datos
     * */
    @Test
    public void getAppByCategory2() throws SQLException {
        String resultado = ApplicationRepository.getAppByCategory("2").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*13
     * ingresando un indentificador del tipo de dato incorrecto
     * */
    @Test
    public void getAppByCategory3() throws SQLException {
        String resultado = ApplicationRepository.getAppByCategory("n").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*14
     * ingresando un indentificador vacio
     * */
    @Test
    public void getAppByCategory4() throws SQLException {
        String resultado = ApplicationRepository.getAppByCategory(" ").toString();
        List<ApplicationEntity> esperado = new ArrayList<ApplicationEntity>();

        assertEquals(resultado,esperado.toString());
    }

    /*casos de prueba para calificar una aplicacion----------------------------------------*/

    /*15
     * ingresando valores de tipo correcto pero y con valores validos
     * */
    @Test
    public void appCalificationTest1() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","1","1");
        String esperado = "02000";
        assertEquals(esperado,resultado);
    }

    /*16
     * ingresando valores de tipo correcto pero y con valores invalidos
     * */
    @Test
    public void appCalificationTest2() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","1","0");
        String esperado = "23503";
        assertEquals(esperado,resultado);
    }

    /*17
 
     * */
    @Test
    public void appCalificationTest3() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","0","1");
        String esperado = "23503";
        assertEquals(esperado,resultado);
    }

    /*18

     * */
    @Test
    public void appCalificationTest4() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("0","1","1");
        String esperado = "puntuacion invalida";
        assertEquals(esperado,resultado);
    }

    /*19

     * */
    @Test
    public void appCalificationTest5() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("6","1","0");
        String esperado = "puntuacion invalida";
        assertEquals(esperado,resultado);
    }

    /*20

     * */
    @Test
    public void appCalificationTest6() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("n","1","0");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*21
     *
     * */
    @Test
    public void appCalificationTest7() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","n","0");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*22
     *
     * */
    @Test
    public void appCalificationTest8() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","1","n");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*23
     *
     * */
    @Test
    public void appCalificationTest9() throws SQLException {
        String resultado = ApplicationRepository.AppCalification(" ","1","1");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*24
     *
     * */
    @Test
    public void appCalificationTest10() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1"," ","1");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*25
     *
     * */
    @Test
    public void appCalificationTest11() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","1"," ");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }

    /*26
     *
     * */
    @Test
    public void appCalificationTest12() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("-1","1","0");
        String esperado = "puntuacion invalida";
        assertEquals(esperado,resultado);
    }

    /*27
     *
     * */
    @Test
    public void appCalificationTest13() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("9","0","1");
        String esperado = "puntuacion invalida";
        assertEquals(esperado,resultado);
    }

    /*28
     *
     * */
    @Test
    public void appCalificationTest14() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("9","1","0");
        String esperado = "puntuacion invalida";
        assertEquals(esperado,resultado);
    }

    /*29
     * i
     * */
    @Test
    public void appCalificationTest15() throws SQLException {
        String resultado = ApplicationRepository.AppCalification("1","-1","0");
        String esperado = "23503";
        assertEquals(esperado,resultado);
    }

    /*30
     *
     * */
    @Test
    public void appCalificationTest16() throws SQLException {
        String resultado = ApplicationRepository.AppCalification(" "," "," ");
        String esperado = "error de tipos de datos";
        assertEquals(esperado,resultado);
    }




}
