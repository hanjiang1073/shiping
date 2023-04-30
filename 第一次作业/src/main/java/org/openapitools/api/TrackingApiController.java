package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class TrackingApiController implements TrackingApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TrackingApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<InlineResponse2001> trackingPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = true) InlineObject3 inlineObject3) {

        int orderid = inlineObject3.getOrder().getOrderid();
        CreateoderUser user = inlineObject3.getUser();
        InlineResponse2001Order order = new InlineResponse2001Order();
        order.setOrderid(orderid);
        order.setPositionStart("start");
        order.setPositionEnd("end");
        order.setPositionNow("now");

        InlineResponse2001 inlineResponse2001 = new InlineResponse2001();
        inlineResponse2001.setUser(user);
        inlineResponse2001.setOrder(order);

        if(orderid>3000){
            inlineResponse2001.getOrder().setPositionNow("null");
            return new ResponseEntity<>(inlineResponse2001, HttpStatus.valueOf(201));
        }

        return new ResponseEntity<>(inlineResponse2001, HttpStatus.valueOf(200));

    }

}
