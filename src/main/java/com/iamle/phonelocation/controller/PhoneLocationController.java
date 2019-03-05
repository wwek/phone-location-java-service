package com.iamle.phonelocation.controller;

import cn.kbyte.utils.phone.PhoneNumberGeo;
import cn.kbyte.utils.phone.PhoneNumberInfo;
import com.iamle.phonelocation.core.ret.RetCode;
import com.iamle.phonelocation.core.ret.RetResponse;
import com.iamle.phonelocation.core.ret.RetResult;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@SpringBootApplication
@RestController
@RequestMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PhoneLocationController {

    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public RetResult<PhoneNumberInfo> phone(@RequestParam(value = "phoneNumber",required = true) String phoneNumber) {
        boolean isPhoneNumber = Pattern.matches("1\\d{6,10}",phoneNumber);
        if (!isPhoneNumber) {
            return RetResponse.makeErrRsp("参数错误，请使用正确的参数");
        }
        PhoneNumberGeo phoneNumberGeo = new PhoneNumberGeo();
        PhoneNumberInfo phoneNumberInfo = phoneNumberGeo.lookup(phoneNumber);
        if (phoneNumberInfo == null) {
            return RetResponse.makeErrRsp("信息为空");
        }
        return RetResponse.makeOKRsp(phoneNumberInfo);
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public RetResult<PhoneNumberInfo> index() {
        String reMsg = "not found";
        return RetResponse.makeErrRsp(reMsg);
    }
}
