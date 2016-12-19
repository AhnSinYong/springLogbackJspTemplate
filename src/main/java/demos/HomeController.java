package demos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ahnsy on 2016-12-19.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/main.do")
    public String home(){
        return "home.tiles";
    }
}
