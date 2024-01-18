package com.cswg.csor.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class JWTSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authz -> authz.requestMatchers(HttpMethod.GET, "/orgs").hasAuthority("SCOPE_csor_ui.read")
				.requestMatchers(HttpMethod.GET, "/orgs/**")
				.hasAuthority("SCOPE_csor_ui.read")
				.requestMatchers(HttpMethod.POST, "/orgs").hasAuthority("SCOPE_csor_ui.read").anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 ->oauth2.jwt(c->{
					Customizer.withDefaults();
					c.jwkSetUri("http://localhost:9080/csor-auth/oauth2/jwks");
				}));
		return http.build();
	}
	

}
