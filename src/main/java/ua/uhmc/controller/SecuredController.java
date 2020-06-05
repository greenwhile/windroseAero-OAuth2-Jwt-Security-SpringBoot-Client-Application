package ua.uhmc.controller;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.uhmc.component.WindmapComponent;

import java.util.ArrayList;
import java.util.List;

//@Controller
public class SecuredController {

//    @Value("${movie.base-uri}")
//    private String movieApiBaseUri;

//    @Value("${windmap.base-uri}")
//    private String windmapApiBaseUri;

//    @Autowired
//    @Qualifier("oauth2AppRestTemplate")
//    private OAuth2RestTemplate oauth2AppRestTemplate;

//    @RequestMapping(value = "/movie", method = RequestMethod.GET)
//    public String movie_root() {
//        return "redirect:/movie/index";
//    }
//
//    @RequestMapping(value = "/movie/index", method = RequestMethod.GET)
//    @ResponseBody
//    public Movie[] movie_index() {
//        System.out.println("movie.base-uri: " + movieApiBaseUri);
//        Movie[] movies = oauth2AppRestTemplate.getForObject(movieApiBaseUri, Movie[].class);
//        System.out.println(oauth2AppRestTemplate.getAccessToken());
//        return movies;
//    }

//    @RequestMapping(value = "/windmap", method = RequestMethod.GET)
//    public String windmap_root() {
//        return "redirect:/windmap/index";
//    }

//    @GetMapping(value = "/windmap/index", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    @ResponseBody
//    public ResponseEntity<byte[]> get_img() {
//        System.out.println("windmap.base-uri: " + windmapApiBaseUri);
//        HttpHeaders headers = new HttpHeaders();
//
//        //This step is not necessary
//        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
//        oauth2AppRestTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
//        acceptableMediaTypes.add(MediaType.IMAGE_PNG);
//        acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
//        headers.setAccept(acceptableMediaTypes);
//        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);
//        ResponseEntity<byte[]> responseEntity = oauth2AppRestTemplate.exchange(windmapApiBaseUri, HttpMethod.GET,
//                httpEntity, byte[].class);
//        System.out.println("resp: " + responseEntity.getBody());
//        System.out.println(oauth2AppRestTemplate.getAccessToken());
//
//        return responseEntity;
//    }

//    @RequestMapping(value = "/current", method = RequestMethod.GET)
//    public String current_root() {
//        return "redirect:/current/index";
//    }
//
//    @GetMapping(value = "/current/index")
//    @ResponseBody
//    public ResponseEntity<WindmapComponent> getCurrentImg() {
//        System.out.println("windmap.base-uri: " + windmapApiBaseUri);
//        HttpHeaders headers = new HttpHeaders();
//        String  url = windmapApiBaseUri.concat("/current").concat("/u_QWAC10_NorthAtl_H 06_K=1406");

        //This step is not necessary
//        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
//        oauth2AppRestTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
//        acceptableMediaTypes.add(MediaType.IMAGE_PNG);
//        acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
//        headers.setAccept(acceptableMediaTypes);
//        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);
//        ResponseEntity<WindmapComponent> responseEntity = oauth2AppRestTemplate.exchange(url, HttpMethod.GET,
//                httpEntity, WindmapComponent.class);
//        System.out.println("resp: " + responseEntity.getBody());
//        System.out.println(oauth2AppRestTemplate.getAccessToken());
//
//        return responseEntity;
//    }

//    @RequestMapping(value = "/up", method = RequestMethod.GET)
//    public String up_root() {
//        return "redirect:/up/index";
//    }

//    @GetMapping(value = "/up/index")
//    @ResponseBody
//    public ResponseEntity<WindmapComponent> getUpImg() {
//        System.out.println("windmap.base-uri: " + windmapApiBaseUri);
//        HttpHeaders headers = new HttpHeaders();
//        String  url = windmapApiBaseUri.concat("/up").concat("/u_QWAC10_NorthAtl_H 06_K=1406");

        //This step is not necessary
//        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
//        oauth2AppRestTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
//        acceptableMediaTypes.add(MediaType.IMAGE_PNG);
//        acceptableMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
//        headers.setAccept(acceptableMediaTypes);
//        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);
//        ResponseEntity<WindmapComponent> responseEntity = oauth2AppRestTemplate.exchange(url, HttpMethod.GET,
//                httpEntity, WindmapComponent.class);
//        System.out.println("resp: " + responseEntity.getBody());
//        System.out.println(oauth2AppRestTemplate.getAccessToken());
//
//        return responseEntity;
//    }

}

