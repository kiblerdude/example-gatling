

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import java.util.UUID
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

trait ExampleApis {
  
  // feeder that generates random UUIDs to use in requests
  val ids = Iterator.continually(Map("id" -> UUID.randomUUID().toString()))  
  
  object CreateEntity {
    val request = scenario("Create API")
      .exec(http("Create Entity")
        .post("/v1/entity"))
  }
  
  object RetrieveEntity {    
    val request = scenario("Retrieve API")
      .feed(ids)
      .exec(http("Retrieve Entity")
        .get("/v1/entity/${id}"))
  } 
  
  object UpdateEntity {
    val request = scenario("Update API")
      .feed(ids)
      .exec(http("Update Entity")
        .put("/v1/entity/${id}"))
  }
}