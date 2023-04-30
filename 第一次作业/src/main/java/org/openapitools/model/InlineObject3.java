package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.CreateoderUser;
import org.openapitools.model.RetrivebillingOrder;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineObject3
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-29T14:09:33.509622300+08:00[Asia/Shanghai]")

public class InlineObject3   {
  @JsonProperty("User")
  private CreateoderUser user;

  @JsonProperty("Order")
  private RetrivebillingOrder order;

  public InlineObject3 user(CreateoderUser user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public CreateoderUser getUser() {
    return user;
  }

  public void setUser(CreateoderUser user) {
    this.user = user;
  }

  public InlineObject3 order(RetrivebillingOrder order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public RetrivebillingOrder getOrder() {
    return order;
  }

  public void setOrder(RetrivebillingOrder order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject3 inlineObject3 = (InlineObject3) o;
    return Objects.equals(this.user, inlineObject3.user) &&
        Objects.equals(this.order, inlineObject3.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject3 {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

