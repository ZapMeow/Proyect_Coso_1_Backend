package levelUp.main.LevelUp.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import levelUp.main.LevelUp.security.jwt.JwtService;
import levelUp.main.LevelUp.service.CustomUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthFilter(JwtService jwtService, CustomUserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("Path used " + path);

        // NO validar token en rutas públicas
        if (path.startsWith("/api/product/getAllProducts") || path.startsWith("/api/auth/") || path.startsWith("/h2-console/")) {
            filterChain.doFilter(request, response);
            System.out.println("doesn't need verification");
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring(7);

                // ⭐ VALIDAR EL TOKEN
                if (jwtService.isTokenValid(token)) {
                    String username = jwtService.extractUsername(token);

                    // ⭐ CARGAR EL USUARIO
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                    // ⭐ CREAR LA AUTENTICACIÓN
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // ⭐ ESTABLECER LA AUTENTICACIÓN EN EL CONTEXTO DE SEGURIDAD
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    System.out.println("❌ Token inválido"); // ⭐ DEBUG
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        filterChain.doFilter(request, response);
    }
}