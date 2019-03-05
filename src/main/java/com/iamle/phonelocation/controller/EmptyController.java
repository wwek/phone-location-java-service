package com.iamle.phonelocation.controller;


import com.iamle.phonelocation.core.ret.RetResponse;
import com.iamle.phonelocation.core.ret.RetResult;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmptyController {
    @RequestMapping(value = "*", method = RequestMethod.GET)
    public RetResult<String> index() {
        String reMsg = "not found";
        return RetResponse.makeErrRsp(reMsg);
    }
}
