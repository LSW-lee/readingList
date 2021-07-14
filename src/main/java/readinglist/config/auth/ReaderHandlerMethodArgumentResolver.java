package readinglist.config.auth;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import readinglist.domain.readers.Readers;

public class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Readers.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication auth = (Authentication) webRequest.getUserPrincipal();
        //boolean isAuthNotNull = auth != null;
        //boolean isInstanceOfReaders = auth.getPrincipal() instanceof Readers;

        return auth != null && auth.getPrincipal() instanceof Readers ? auth.getPrincipal() : null;
    }
}
