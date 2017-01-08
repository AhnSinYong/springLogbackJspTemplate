package com.ahn.validation;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestValidator {

    @Test
    public void testJsr303BeanValidator() throws ServletException, IOException {
        ConfigurableDispatcherServlet servlet = new ConfigurableDispatcherServlet();
        //servlet.setContextConfigLocation("jsr-303-validation.xml");
        //servlet.setLocations("file:jsr-303-validation.xml");
        servlet.setRelativeLocations(getClass(), "jsr-303-validation");
        servlet.init(new MockServletConfig("dispatcherServlet"));

        MockHttpServletRequest req = new MockHttpServletRequest("POST", "/user");
        req.addParameter("id", "test1234567"); // not null, min 4, max 10
        req.addParameter("name", "안신용"); // not null, min 10
        req.addParameter("password", "1qaz1234"); // not null, min 6, max 20
        req.addParameter("age", "34"); // min 1, max 200

        MockHttpServletResponse res = new MockHttpServletResponse();
        servlet.service(req, res);

        assertThat(servlet.getModelAndView().getViewName(), is("successView"));
    }
}
