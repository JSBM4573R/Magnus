package com.system.reservation.magnus.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOAuth2Controller {
    @GetMapping("/OAuth2User")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
        try {
            return Collections.singletonMap("name", principal.getAttribute("name"));
        } catch (Exception e) {
            Map<String, Object> m1 = new HashMap<String, Object>();
            return m1;
        }
    }
}
