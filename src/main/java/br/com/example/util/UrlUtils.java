package br.com.example.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

import static br.com.example.constants.StringConstants.SLASH;

@Component
public class UrlUtils {
    public URI getCreatedLocation(Long id) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestUri = StringUtils.defaultString(httpServletRequest.getRequestURI());
        StringBuilder sb = new StringBuilder();

        sb.append(requestUri);

        if (!StringUtils.endsWith(requestUri, SLASH)) {
            sb.append(SLASH);
        }

        sb.append(id);

        return URI.create(sb.toString());
    }
}
