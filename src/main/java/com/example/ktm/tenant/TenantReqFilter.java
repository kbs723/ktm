package com.example.ktm.tenant;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import static com.example.ktm.constants.AppConst.LOG_EXCEPTION;

@Component
public class TenantReqFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(TenantReqFilter.class);

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) {

        try {
            String tenant = request.getHeader("X-Tenant");
            TenantContext.set(tenant);
            filterChain.doFilter(request, response);
        }
        catch (Exception ex){
            log.error(LOG_EXCEPTION, ex);
        }
        finally {
            TenantContext.clear();
        }
    }
}
