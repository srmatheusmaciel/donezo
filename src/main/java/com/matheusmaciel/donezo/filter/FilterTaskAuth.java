package com.matheusmaciel.donezo.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.matheusmaciel.donezo.user.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
       
        // Pegar a autenticação (usuario e senha)
        var authorization =  request.getHeader("Authorization");

        //remover a palavra Basic que fica escrito no authorization
        var authEncoded  = authorization.substring("Basic".length()).trim();
       
        // fazer um decode dos caracteres
        byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
        
        // converter para string
        var authString  = new String(authDecoded);
        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];
        
        // Validar usuario
          var user = this.userRepository.findByUsername(username);
          if(user == null) {
            response.sendError(401);
          } else{
            
            //Validar a senha
            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if(passwordVerify.verified){
              filterChain.doFilter(request, response);
            } else {
              response.sendError(401);
            }
          }
        

          //prosseguir 
        
        
  }

 

}
