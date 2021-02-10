package com.michael.shorturl.controllers;

import com.michael.shorturl.Repository.URLRepository;
import com.michael.shorturl.models.ShortURL;
import com.michael.shorturl.entity.LongURL;
import com.michael.shorturl.exceptions.CodeNotFoundException;
import com.michael.shorturl.exceptions.InvalidURLException;
import com.michael.shorturl.util.Base62Converter;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortURLController {


    private final URLRepository urlRepository;
    private Base62Converter converter = new Base62Converter();

    public ShortURLController(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
    @PostMapping("/shorturl")
    @ResponseBody
    public ShortURL shortURL(@RequestBody LongURL url) {

        UrlValidator urlValidator = new UrlValidator();
        if(!urlValidator.isValid(url.getLongUrl())){
            throw new InvalidURLException(url.getLongUrl());
        }
        //create LongURL object, set initial values and store to db
        url.setClicks(0);
        url.setCreateTime();
        urlRepository.save(url);
        ShortURL shortLink = new ShortURL();
        //generates short link by taking id and converting to base62
        shortLink.setShortURL(converter.toBase62(url.getId()));
        return shortLink;
    }

    //redirects to long URL stored using encoded id
    @RequestMapping(value ="/{code}")
    public RedirectView redirectWithRedirectView(@PathVariable(value="code") String code)  {
        RedirectView redirectView = new RedirectView();
        //converts base62 id back to base10
        int id = converter.toBase10(code);

        //updates long_url table
        try {
            LongURL result = urlRepository.findLongUrlById(id);
            result.setClicks(result.getClicks() + 1);
            result.setLastVisited();
            urlRepository.save(result);
            redirectView.setUrl(result.getLongUrl());
        } catch (Exception e){
            throw new CodeNotFoundException(code);
        }
        return redirectView;
    }

    //shows long_url row data
    @GetMapping("/analytics/{code}")
    public LongURL findUrlById(@PathVariable String code) {
        int id = converter.toBase10(code);

        LongURL longURL = urlRepository.findLongUrlById(id);
        if(longURL == null){
            throw new CodeNotFoundException(code);
        }
        return longURL;

    }

}