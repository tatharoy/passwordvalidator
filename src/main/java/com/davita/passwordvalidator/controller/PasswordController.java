package com.davita.passwordvalidator.controller;

import com.davita.passwordvalidator.service.PasswordService;
import com.davita.passwordvalidator.service.ValidatorService;
import com.davita.passwordvalidator.util.ValidationResult;


import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;



@Controller
@RequestMapping(value = "/passwords")
public class PasswordController {

    public static final String HEADER_STATUS_CODE = "status";

    public static final String BODY = "body";

    /** The logger. */
    private final Logger log = LoggerFactory.getLogger(PasswordController.class);

    @Autowired
    private PasswordService passwordService;
    
    @Autowired
    private ValidatorService validatorService;

    /**
     * Save a password. Before saving a password is validated according to the existing rules
     * @param password
     * @return The Json output
     */
    @RequestMapping(method = RequestMethod.POST, value = "",params="password", produces = "application/json")
    public Map<String, Object> add(ModelMap requestModel,@NotNull @NotEmpty @RequestParam String password) {
        Map<String, Object> output = new HashMap<String, Object>();
        log.info("password being validated {}",password);
        ValidationResult result =  validatorService.validate(password);
        if(result.isValid()){
        	log.info("password being saved {}",password);
        	passwordService.save(password);
        	output.put(HEADER_STATUS_CODE,new Integer(201));
        }else{
        	output.put(HEADER_STATUS_CODE,new Integer(400));
        	output.put(BODY,result.getValidationErrors());
        }
        
        return output;
    }
    
    /**
     * Validate a password. A password is validated according to the existing rules
     * @param password
     * @return The json output
     */
    @RequestMapping(method = RequestMethod.GET, value = "/validate",params="password", produces = "application/json")
    public Map<String, Object> validate(ModelMap requestModel,@NotNull @NotEmpty @RequestParam String password) {
        Map<String, Object> output = new HashMap<String, Object>();
        log.info("password being validated {}",password);
        ValidationResult result =  validatorService.validate(password);
        if(result.isValid()){
        	output.put(HEADER_STATUS_CODE,new Integer(200));
        }else{
        	output.put(HEADER_STATUS_CODE,new Integer(400));
        	output.put(BODY,result.getValidationErrors());
        }
        
        return output;
    }

    


}
