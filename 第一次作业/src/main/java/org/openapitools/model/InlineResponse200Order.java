package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200Order
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

public class InlineResponse200Order   {
  @JsonProperty("orderid")
  private Integer orderid;

  @JsonProperty("bill")
  private BigDecimal bill;

  public InlineResponse200Order orderid(Integer orderid) {
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

  public InlineResponse200Order bill(BigDecimal bill) {
    this.bill = bill;
    return this;
  }

  /**
   * Get bill
   * minimum: 0
   * @return bill
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid
@DecimalMin("0")
  public BigDecimal getBill() {
    return bill;
  }

  public void setBill(BigDecimal bill) {
    this.bill = bill;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200Order inlineResponse200Order = (InlineResponse200Order) o;
    return Objects.equals(this.orderid, inlineResponse200Order.orderid) &&
        Objects.equals(this.bill, inlineResponse200Order.bill);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderid, bill);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200Order {\n");
    
    sb.append("    orderid: ").append(toIndentedString(orderid)).append("\n");
    sb.append("    bill: ").append(toIndentedString(bill)).append("\n");
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

