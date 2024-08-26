package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.JwtRequest;
import com.entrepreneur.brent_with_sas.model.JwtResponse;
import com.entrepreneur.brent_with_sas.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
