package demos;

import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Set;


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
    public ModelAndView handleRequest(HttpSession session,
                                      HttpServletRequest request
    ) throws IOException {
        Set<String> resourcePaths = session.getServletContext().getResourcePaths("/");
        System.out.println(resourcePaths);

        Set<String> resourcePaths1 = request.getServletContext().getResourcePaths("/");
        System.out.println(resourcePaths1);

        String pdfPath = session.getServletContext().getRealPath("/email/test.html");
        System.out.println(new File(pdfPath).exists());
        System.out.println(Files.toString(new File(pdfPath), Charset.forName("UTF-8")));
        System.out.println(IOUtils.toString(new FileInputStream(new File(pdfPath)), "UTF-8"));

        return new ModelAndView("home");
    }
}
