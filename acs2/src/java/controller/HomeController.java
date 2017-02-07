package controller;

import auth.annotation.Logado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class HomeController extends AbstractController {

    public HomeController() {

    }

    @Path("/")
    @Logado
    public void index() {

    }

    public void restrito() {
    }

}