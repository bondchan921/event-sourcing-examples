package net.chrisrichardson.eventstore.javaexamples.banking.apigateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;

@ConfigurationProperties(prefix = "api.gateway")
public class ApiGatewayProperties {

  private List<Endpoint> endpoints;

  public static class Endpoint {
    private String path;
    private RequestMethod method;
    private String location;

    public Endpoint() {
    }

    public Endpoint(String location) {
      this.location = location;
    }

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }

    public RequestMethod getMethod() {
      return method;
    }

    public void setMethod(RequestMethod method) {
      this.method = method;
    }

    public String getLocation() {
      return location;
    }

    public void setLocation(String location) {
      this.location = location;
    }

    @Override
    public String toString(){
      return "Endpoint{" +
              "path:" + path +
              ",method:" + method
              ",location:" + location
              "}"
    }
  }

  public List<Endpoint> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<Endpoint> endpoints) {
    this.endpoints = endpoints;
  }

  @Override
  public String toString(){
    return endpoints.stream().map(endpoint -> {return endpoint.toString()}).reduce("", String::concat);
  }
}
