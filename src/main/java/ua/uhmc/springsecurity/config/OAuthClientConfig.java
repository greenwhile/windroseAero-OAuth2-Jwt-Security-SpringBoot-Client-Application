package ua.uhmc.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@Configuration
@EnableOAuth2Client
public class OAuthClientConfig {

    @Autowired
    private OAuth2ClientContext oauth2ClientContext;

    @Autowired
    private OAuth2ProtectedResourceDetails oauth2AppClientDetails;

    @ConfigurationProperties(prefix = "app.security.oauth2.client")
    @Bean
    public OAuth2ProtectedResourceDetails oauth2AppClientDetails() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public OAuth2RestTemplate oauth2AppRestTemplate() {
        return new OAuth2RestTemplate(oauth2AppClientDetails, oauth2ClientContext);
    }

}

