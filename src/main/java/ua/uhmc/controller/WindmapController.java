package ua.uhmc.controller;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ua.uhmc.component.WindmapComponent;
import ua.uhmc.model.Admin;
import ua.uhmc.model.Windmap;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@Controller
public class WindmapController {

    private String imageFilename;
    private String imageFilenameUrl;
    private byte [] windmapImage;
    private WindmapComponent windmapComponent;
    private String validityIndex;
    private String levelIndex;

    @Value("${windmap.base-uri}")
    private String windmapApiBaseUri;

    @Autowired
    @Qualifier("oauth2AppRestTemplate")
    private OAuth2RestTemplate oauth2AppRestTemplate;

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String getCurrentWindmapImagename(
            @ModelAttribute("windmapComponent") WindmapComponent windmapComponent,
            HttpServletRequest httpServletRequest,
            @RequestParam(value="action", required=true) String action,
            Model model){

        System.out.println("client url: " + httpServletRequest.getRequestURL());
        System.out.println("req_area: " + httpServletRequest.getParameter("areas"));
        System.out.println("req_date: " + httpServletRequest.getParameter("grib2Dates"));
        System.out.println("req_level: " + httpServletRequest.getParameter("levels"));
        System.out.println("req_validity: " + httpServletRequest.getParameter("validities"));

        Windmap windmap = new Windmap(
                httpServletRequest.getParameter("areas"),
                httpServletRequest.getParameter("grib2Dates"),
                httpServletRequest.getParameter("levels"),
                httpServletRequest.getParameter("validities"));
        System.out.println("windmap => " + windmap);

        String dayOfYear = "09";

        this.imageFilename =
                "u_QW" +
                windmap.getT1() +
                windmap.getValidityCode() +
                windmap.getLevel() + "_" +
                windmap.getTerritory() + "_" +
                "H+" +
                windmap.getValidity() + "_" +
                "K=" +
                dayOfYear +
                windmap.getObservation();

        switch(action) {
            case "current":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
//                imageUrl = imageUrl.concat(action);
                break;
            default:
                model.addAttribute("action", action);
                System.out.println("Please, set necessary image filename!");
                break;
        }

        model.addAttribute("imageFilename", this.imageFilename);
        System.out.println("file: " + this.imageFilename);

        return "redirect:/windmap";
    }

    @RequestMapping(value="/windmap", method=RequestMethod.GET)
    public String windmap(@ModelAttribute("windmapComponent") WindmapComponent windmapComponent, Model model){

        System.out.println("Start of POST Windmap form");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);

        String imageUrl = windmapApiBaseUri;
               imageUrl = imageUrl.concat("/").concat(this.imageFilename);

        System.out.println("file: " + this.imageFilename);
        System.out.println("imageUrl: " + imageUrl);

        ResponseEntity<WindmapComponent> responseEntity = oauth2AppRestTemplate.exchange(
                imageUrl,
                HttpMethod.GET,
                httpEntity,
                WindmapComponent.class);
//        System.out.println("resp: " + responseEntity.getBody());

        this.windmapComponent = new WindmapComponent(
                    responseEntity.getBody().getWindmapImageFilename(),
                    responseEntity.getBody().getValidityIndex(),
                    responseEntity.getBody().getLevelIndex(),
                    responseEntity.getBody().getCurrentWindmapImage()
                );
        System.out.println("windmapComponent: " + this.windmapComponent);

        model.addAttribute("windmapComponent", this.windmapComponent);

        model.addAttribute("validityIndex", responseEntity.getBody().getValidityIndex());
        model.addAttribute("levelIndex", responseEntity.getBody().getLevelIndex());

        System.out.println("getLevelIndex: " + responseEntity.getBody().getLevelIndex());
        System.out.println("getValidityIndex: " + responseEntity.getBody().getValidityIndex());

        this.windmapImage = responseEntity.getBody().getCurrentWindmapImage();
        this.imageFilename = responseEntity.getBody().getWindmapImageFilename().replace(".png", "");
        this.imageFilenameUrl = "http://localhost:8080".concat("/").concat("image");

        model.addAttribute("imageFilenameUrl", this.imageFilenameUrl);
        model.addAttribute("imageFilename", this.imageFilename);

        System.out.println("imageFilenameUrl: " + this.imageFilenameUrl);
        System.out.println("imageFilename: " + this.imageFilename);

        System.out.println("End of POST Windmap form");

        return "index";
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String get_search(@ModelAttribute("windmapComponent") WindmapComponent windmapComponent, @RequestParam(value="action", required=true) String action, Model model){

        System.out.println("Start of GET Search form");
        String dayOfYear = "09";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Request> httpEntity = new HttpEntity<Request>(headers);

        String imageUrl = windmapApiBaseUri.concat("/");

        switch(action) {
            case "up":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
                imageUrl = imageUrl.concat(action);
                break;
            case "down":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
                imageUrl = imageUrl.concat(action);
                break;
            case "right":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
                imageUrl = imageUrl.concat(action);
                break;
            case "left":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
                imageUrl = imageUrl.concat(action);
                break;
            case "save":
                model.addAttribute("action", action);
                System.out.println("action => " + action);
                imageUrl = imageUrl.concat(action);
                break;
            default:
                model.addAttribute("action", action);
                System.out.println("Please, set necessary image filename!");
                break;
        }

        imageUrl = imageUrl.concat("/").concat(this.imageFilename);

        model.addAttribute("imageFilename", this.imageFilename);
        model.addAttribute("imageUrl", imageUrl);

        System.out.println("imageFilename: " + this.imageFilename);
        System.out.println("imageUrl: " + imageUrl);

        ResponseEntity<WindmapComponent> responseEntity = oauth2AppRestTemplate.exchange(
                imageUrl,
                HttpMethod.GET,
                httpEntity,
                WindmapComponent.class);

        this.windmapComponent = new WindmapComponent(
                responseEntity.getBody().getWindmapImageFilename(),
                responseEntity.getBody().getValidityIndex(),
                responseEntity.getBody().getLevelIndex(),
                responseEntity.getBody().getCurrentWindmapImage()
        );
        System.out.println("windmapComponent: " + this.windmapComponent);

        model.addAttribute("windmapComponent", this.windmapComponent);

        model.addAttribute("validityIndex", responseEntity.getBody().getValidityIndex());
        model.addAttribute("levelIndex", responseEntity.getBody().getLevelIndex());

        System.out.println("getLevelIndex: " + responseEntity.getBody().getLevelIndex());
        System.out.println("getValidityIndex: " + responseEntity.getBody().getValidityIndex());

        this.windmapImage = responseEntity.getBody().getCurrentWindmapImage();
        this.imageFilename = responseEntity.getBody().getWindmapImageFilename().replace(".png", "");
        this.imageFilenameUrl = "http://localhost:8080".concat("/").concat("image");

        model.addAttribute("imageFilenameUrl", this.imageFilenameUrl);
        model.addAttribute("imageFilename", this.imageFilename);

        System.out.println("imageFilenameUrl: " + this.imageFilenameUrl);
        System.out.println("imageFilename: " + this.imageFilename);

        System.out.println("End of GET Search form");

        return "index";
    }

    @RequestMapping(value="/image", method=RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getWindmapImage(HttpServletRequest httpServletRequest){
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(this.windmapImage);
    }

    @RequestMapping("/get-admin")
    public String get_search(Model model){
        int random_id = 0 + (int)(Math.random() * (10 - 0) + 1 );
        Admin adminObj = new Admin(random_id);
        model.addAttribute("adminObj", adminObj);
        model.addAttribute("id", adminObj.getId());
        System.out.println("admin: " + adminObj);
        return "admin";
    }

}

//        int random_id = 0 + (int)(Math.random() * (10 - 0) + 1 );
//        Admin adminObj = new Admin(random_id);
//        model.addAttribute("adminObj", adminObj);
//        model.addAttribute("id", adminObj.getId());
//        System.out.println("admin: " + adminObj);

//        windmapComponent = new WindmapComponent();
//        model.addAttribute(windmapComponent);
