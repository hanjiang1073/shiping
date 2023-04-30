package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RetrivebillingOrder
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

public class RetrivebillingOrder   {
  @JsonProperty("orderid")
  private Integer orderid;

  public RetrivebillingOrder orderid(Integer orderid) {
    this.orderid = orderid;
    return this;
  }

  /**
   * Get orderid
   * minimum: 1
   * maximum: 5000
   * @return orderid
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(1) @Max(5000) 
  public Integer getOrderid() {
    return orderid;
  }

  public void setOrderid(Integer orderid) {
    this.orderid = orderid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetrivebillingOrder retrivebillingOrder = (RetrivebillingOrder) o;
    return Objects.equals(this.orderid, retrivebillingOrder.orderid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetrivebillingOrder {\n");
    
    sb.append("    orderid: ").append(toIndentedString(orderid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

