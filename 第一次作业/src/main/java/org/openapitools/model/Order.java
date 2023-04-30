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
 * Order
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

public class Order   {
  @JsonProperty("orderid")
  private Integer orderid;

  @JsonProperty("bill")
  private BigDecimal bill;

  @JsonProperty("position_now")
  private String positionNow;

  @JsonProperty("position_start")
  private String positionStart;

  @JsonProperty("position_end")
  private String positionEnd;

  public Order orderid(Integer orderid) {
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

  public Order bill(BigDecimal bill) {
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

  public Order positionNow(String positionNow) {
    this.positionNow = positionNow;
    return this;
  }

  /**
   * 货物现在的位置
   * @return positionNow
  */
  @ApiModelProperty(required = true, value = "货物现在的位置")
  @NotNull


  public String getPositionNow() {
    return positionNow;
  }

  public void setPositionNow(String positionNow) {
    this.positionNow = positionNow;
  }

  public Order positionStart(String positionStart) {
    this.positionStart = positionStart;
    return this;
  }

  /**
   * 货物起始位置
   * @return positionStart
  */
  @ApiModelProperty(required = true, value = "货物起始位置")
  @NotNull


  public String getPositionStart() {
    return positionStart;
  }

  public void setPositionStart(String positionStart) {
    this.positionStart = positionStart;
  }

  public Order positionEnd(String positionEnd) {
    this.positionEnd = positionEnd;
    return this;
  }

  /**
   * 货物目的地
   * @return positionEnd
  */
  @ApiModelProperty(required = true, value = "货物目的地")
  @NotNull


  public String getPositionEnd() {
    return positionEnd;
  }

  public void setPositionEnd(String positionEnd) {
    this.positionEnd = positionEnd;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.orderid, order.orderid) &&
        Objects.equals(this.bill, order.bill) &&
        Objects.equals(this.positionNow, order.positionNow) &&
        Objects.equals(this.positionStart, order.positionStart) &&
        Objects.equals(this.positionEnd, order.positionEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderid, bill, positionNow, positionStart, positionEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    orderid: ").append(toIndentedString(orderid)).append("\n");
    sb.append("    bill: ").append(toIndentedString(bill)).append("\n");
    sb.append("    positionNow: ").append(toIndentedString(positionNow)).append("\n");
    sb.append("    positionStart: ").append(toIndentedString(positionStart)).append("\n");
    sb.append("    positionEnd: ").append(toIndentedString(positionEnd)).append("\n");
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

