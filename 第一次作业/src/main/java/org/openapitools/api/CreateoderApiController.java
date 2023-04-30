package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.CreateoderOrder;
import org.openapitools.model.InlineObject1;
import org.openapitools.service.Impl.AccountServiceImpl;
import org.openapitools.service.ShipOrderService;
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
public class CreateoderApiController implements CreateoderApi {

    private final NativeWebRequest request;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private ShipOrderService shipOrderService;

    @org.springframework.beans.factory.annotation.Autowired
    public CreateoderApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Boolean> createoderPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = true) InlineObject1 inlineObject1) {
        int id = inlineObject1.getUser().getId().intValue();
        CreateoderOrder order = inlineObject1.getOrder();
        if(shipOrderService.addShipOrder(id, order)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        }
        return new ResponseEntity<>(false,HttpStatus.valueOf(201));

    }

}
