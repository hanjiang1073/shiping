/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.InlineObject2;
import org.openapitools.model.InlineResponse200;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

@Validated
@Api(value = "retrivebilling", description = "the retrivebilling API")
public interface RetrivebillingApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /retrivebilling : retrive carriers billing
     * retrive carriers billing
     *
     * @param inlineObject2  (optional)
     * @return 成功 (status code 200)
     *         or 失败 (status code 201)
     */
    @ApiOperation(value = "retrive carriers billing", nickname = "retrivebillingPost", notes = "retrive carriers billing", response = InlineResponse200.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "成功", response = InlineResponse200.class),
        @ApiResponse(code = 201, message = "失败", response = Boolean.class) })
    @RequestMapping(value = "/retrivebilling",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<InlineResponse200> retrivebillingPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) InlineObject2 inlineObject2) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"Order\" : { \"orderid\" : 3014, \"bill\" : 0.14658129805029452 }, \"User\" : { \"id\" : 401 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
