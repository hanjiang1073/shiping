package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.InlineObject;
import org.openapitools.model.User;
import org.openapitools.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

@Controller
@RequestMapping("${openapi.shipping.base-path:}")
public class CreateaccountApiController implements CreateaccountApi {

    private final NativeWebRequest request;

    @Autowired
    private AccountServiceImpl accountService;

    @org.springframework.beans.factory.annotation.Autowired
    public CreateaccountApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Boolean> createaccountPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = true) InlineObject inlineObject) {

        User user = inlineObject.getUser();

        //判断用户是否存在
        if(accountService.addUser(user)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        }

        return new ResponseEntity<>(false,HttpStatus.valueOf(201));

    }

}
