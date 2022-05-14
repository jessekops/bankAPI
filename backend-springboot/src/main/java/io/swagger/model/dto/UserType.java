package io.swagger.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets UserType
 */
public enum UserType {
  EMPLOYEE("employee"),
    CUSTOMER("customer");

  private String value;

  UserType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UserType fromValue(String text) {
    for (UserType b : UserType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
