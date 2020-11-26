package com.hcg.mastermicroservices.user.configuration;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
/**
 * @author hcguler
 */

@Component
public class InfoDetailMasterMicroservices implements InfoContributor {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    public InfoDetailMasterMicroservices(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        List<Map<String, String>> details = new ArrayList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
            HashMap<String, String> serviceInfoMap = new HashMap<>(handlerMethods.entrySet().size());
            RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();

            String name = requestMappingInfo.getName();
            if (StringUtils.isNotEmpty(name)) {
                serviceInfoMap.put("Name: ", name);
            }
            PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
            Set<String> patterns = patternsCondition.getPatterns();
            if (StringUtils.isNotEmpty(name)) {
                serviceInfoMap.put("Pattern: ", patterns.toString());
            }

            details.add(serviceInfoMap);
        }
        builder.withDetail("hcg", details);
    }
}
