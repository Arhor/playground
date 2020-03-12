package by.arhor.playground.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RouterConfig {

  @Bean
  public RouterFunction<ServerResponse> indexRouter(
      @Value("classpath:/static/index.html") Resource indexHtml) {
    return route(GET("/"), request ->
        ok().contentType(MediaType.TEXT_HTML)
            .bodyValue(indexHtml));
  }
}
