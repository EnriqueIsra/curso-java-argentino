package org.eitorresmendoza.apiservlet.webapp.cookie.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginService;
import org.eitorresmendoza.apiservlet.webapp.cookie.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;


@WebFilter({"/carro/*", "/productos/form/*", "/productos/eliminar/*", "/usuarios/form/*", "/usuarios/eliminar/*"})
public class LoginFiltro implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImpl();
        Optional<String> username = service.getUsername((HttpServletRequest) request);
        if (username.isPresent()){
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Lo sentimos, no estás autorizado para ingresar a esta página, debes iniciar sesión");
        }
    }
}
