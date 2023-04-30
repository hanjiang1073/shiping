/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.InlineObject3;
import org.openapitools.model.InlineResponse2001;
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
@Api(value = "tracking", description = "the tracking API")
public interface TrackingApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /tracking : tracking the shipments
     * tracking the shipments and transportation
     *
     * @param inlineObject3  (optional)
     * @return 成功 (status code 200)
     *         or 失败 (status code 201)
     */
    @ApiOperation(value = "tracking the shipments", nickname = "trackingPost", notes = "tracking the shipments and transportation", response = InlineResponse2001.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "成功", response = InlineResponse2001.class),
        @ApiResponse(code = 201, message = "失败", response = Boolean.class) })
    @RequestMapping(value = "/tracking",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<InlineResponse2001> trackingPost(@ApiParam(value = ""  )  @Valid @RequestBody(required = false) InlineObject3 inlineObject3) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"Order\" : { \"orderid\" : 401, \"position_end\" : \"position_end\", \"position_now\" : \"position_now\", \"position_start\" : \"position_start\" }, \"User\" : { \"id\" : 401 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
