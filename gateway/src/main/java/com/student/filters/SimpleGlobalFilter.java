package com.student.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import org.springframework.web.server.ServerWebExchange;

@Component
@Order(1)
public class SimpleGlobalFilter implements GlobalFilter {

  private static final Logger log = LoggerFactory.getLogger(SimpleGlobalFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
    log.info("Request Path: " + exchange.getRequest().getPath());
    return chain.filter(exchange);
  }
}