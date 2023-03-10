package a00reflection.target;



import a00reflection.annotation.Controller;
import a00reflection.annotation.RequestMapping;
import a00reflection.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }


}
