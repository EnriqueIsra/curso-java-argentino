package com.enrique.springcloud.app.gateway.filters;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
// import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter, Ordered {
   private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

   public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
      this.logger.info("ejecutando el filtro antes del request PRE");
      ServerHttpRequest request = exchange.getRequest().mutate()
        .headers(h -> h.add("token", "abcdefg")).build();

        ServerWebExchange mutatedExchange = exchange.mutate().request(request).build();

      return chain.filter(mutatedExchange).then(Mono.fromRunnable(() -> {
         this.logger.info("ejecutando filtro POST response");
         String token = mutatedExchange.getRequest().getHeaders().getFirst("token");
         if (token != null) {
            this.logger.info("token: " + token);
            mutatedExchange.getResponse().getHeaders().add("token", token);
         }

         Optional.ofNullable(mutatedExchange.getRequest().getHeaders().getFirst("token")).ifPresent((value) -> {
            this.logger.info("token2: " + value);
            mutatedExchange.getResponse().getHeaders().add("token2", value);
         });
         mutatedExchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
         // mutatedExchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
      }));
   }

   public int getOrder() {
      return 100;
   }
}
