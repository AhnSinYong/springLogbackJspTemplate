package demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by ahnsy on 2016-12-18.
 */
@Controller
public class MainController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String Index(Model model) throws Exception {

        logger.info("index.....");

        System.out.println("index");

        return "home";

    }

    @RequestMapping(value = "home.do")
    public ModelAndView handleRequest() {
        return new ModelAndView("home");
    }
}
