package online.koymattprogrammer.libauth.Filters;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Order(1)
public class AuthFilter implements Filter {

    private final List<String> authPaths;
    public AuthFilter(List<String> paths) {
        this.authPaths = paths;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest; // Cast
        String path = httpRequest.getRequestURI();
        if (authPaths.contains(path)) {
            System.out.println("Contem !!");
        }else  {
            System.out.println("Não contem !!");
        }
    }
}
