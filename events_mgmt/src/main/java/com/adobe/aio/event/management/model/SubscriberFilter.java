package com.adobe.aio.event.management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;

import static java.util.Objects.hash;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Resource
public class SubscriberFilter {

  @JsonProperty("subscriber_filter")
  protected JsonNode subscriberFilter;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriberFilter that = (SubscriberFilter) o;
    return that.getSubscriberFilter().equals(this.subscriberFilter);
  }

  public JsonNode getSubscriberFilter() {
    return subscriberFilter;
  }

  @Override
  public int hashCode() {
    return hash(subscriberFilter);
  }

  @Override
  public String toString() {
    return String.format("SubscriberFilterModel{subscriberFilter=%s}", subscriberFilter);
  }
}
