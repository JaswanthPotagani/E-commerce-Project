package com.sai.ecom_proj.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.ecom_proj.model.Product;
import com.sai.ecom_proj.repo.ProductRepo;
import com.sai.ecom_proj.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;  // use your JwtUtil class

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Extract username/email from OAuth2 authentication
        String username = null;
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();
            username = oauthUser.getAttribute("email"); // Google gives email
        } else {
            username = authentication.getName();
        }

        // Generate JWT token with username
        String token = jwtUtil.generateToken(username);

        // Fetch all products from DB
        List<Product> products = productRepo.findAll();

        // Prepare JSON response
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("token", token);
        responseBody.put("products", products);

        // Write response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(responseBody));    }
}
