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
 * CreateoderOrder
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

public class CreateoderOrder   {
  @JsonProperty("orderid")
  private Integer orderid;

  @JsonProperty("position_start")
  private String positionStart;

  @JsonProperty("position_end")
  private String positionEnd;

  public CreateoderOrder orderid(Integer orderid) {
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

  public CreateoderOrder positionStart(String positionStart) {
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

  public CreateoderOrder positionEnd(String positionEnd) {
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
    CreateoderOrder createoderOrder = (CreateoderOrder) o;
    return Objects.equals(this.orderid, createoderOrder.orderid) &&
        Objects.equals(this.positionStart, createoderOrder.positionStart) &&
        Objects.equals(this.positionEnd, createoderOrder.positionEnd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderid, positionStart, positionEnd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateoderOrder {\n");
    
    sb.append("    orderid: ").append(toIndentedString(orderid)).append("\n");
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

