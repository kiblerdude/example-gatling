

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.http.config.HttpProtocolBuilder.toHttpProtocol

class ExampleApiSimulation extends Simulation with ExampleApis {
  
  val httpConf = http.baseURL("http://localhost:8080")

  val scn = scenario("Retrieve API Performance Test")
    .forever(
        exec(RetrieveEntity.request))
  
  setUp(
    scn.inject(
        rampUsers(500) over(30 seconds))
  ).maxDuration(60 seconds).protocols(httpConf)
}