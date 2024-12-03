package com.adobe.aio.event.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import static java.util.Objects.hash;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriberFilterInputModel {

  @JsonProperty("subscriber_filter")
  protected JsonNode subscriberFilter;

  private SubscriberFilterInputModel(JsonNode subscriberFilter) {
    this.subscriberFilter = subscriberFilter;
  }

  public JsonNode getSubscriberFilter() {
    return subscriberFilter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriberFilterInputModel that = (SubscriberFilterInputModel) o;
    return that.getSubscriberFilter().equals(this.subscriberFilter);
  }

  @Override
  public int hashCode() {
    return hash(subscriberFilter);
  }

  @Override
  public String toString() {
    return String.format("SubscriberFilterModel{subscriberFilter=%s}", subscriberFilter);
  }

  @JsonIgnore
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private JsonNode subscriberFilter;

    public Builder subscriberFilter(JsonNode subscriberFilter) {
      this.subscriberFilter = subscriberFilter;
      return this;
    }

    public SubscriberFilterInputModel build() {
      return new SubscriberFilterInputModel(subscriberFilter);
    }
  }
}
