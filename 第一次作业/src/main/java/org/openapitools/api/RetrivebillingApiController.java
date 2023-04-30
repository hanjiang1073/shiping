package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.InlineObject2;
import org.openapitools.model.InlineResponse200;
import org.openapitools.model.InlineResponse200Order;
import org.openapitools.model.User;
import org.openapitools.service.Impl.AccountServiceImpl;
import org.openapitools.service.ShipOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

@Controller
@RequestMapping("${openapi.shipping.base-path:}")
public class RetrivebillingApiController implements RetrivebillingApi {

    private final NativeWebRequest request;

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private ShipOrderService shipOrderService;

    @org.springframework.beans.factory.annotation.Autowired
    public RetrivebillingApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<InlineResponse200> retrivebillingPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = true) InlineObject2 inlineObject2) {


        Integer id = inlineObject2.getUser().getId();
        InlineResponse200Order order = new InlineResponse200Order();
        order.setBill(new BigDecimal(1.0));
        order.setOrderid(id);

        InlineResponse200 inlineResponse200 = new InlineResponse200();
        inlineResponse200.setUser(inlineObject2.getUser());
        inlineResponse200.setOrder(order);
        if(id.intValue()>4000){
            inlineResponse200.getOrder().setBill(new BigDecimal(0));
            return new ResponseEntity<>(inlineResponse200, HttpStatus.valueOf(201));
        }

        return new ResponseEntity<>(inlineResponse200, HttpStatus.valueOf(200));

    }

}
