package com.ahn.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class ControllerUsingJsr303Validation {

    private Validator validator;

    @PostConstruct
    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    //@RequestMapping
    //public String add(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
    //    if(result.hasErrors()) {
    //        for(ObjectError error : result.getAllErrors()) {
    //            System.out.println(error.getCode() + " : " + error.getDefaultMessage());
    //        }
    //        return "errorView";
    //    }
    //
    //    return "successView";
    //}

    @RequestMapping
    public String add(HttpServletRequest request, Model model) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setId(request.getParameter("id"));
        user.setPassword(request.getParameter("password"));
        user.setAge(Integer.parseInt(request.getParameter("age")));

        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);

        if (!constraintViolationSet.isEmpty()) {
            for (ConstraintViolation<User> violation : constraintViolationSet) {
                System.out.println(violation.getPropertyPath() + " : " + violation.getInvalidValue());
                System.out.println(violation.getMessage());
            }
            return "errorView";
        }

        return "successView";
    }

}