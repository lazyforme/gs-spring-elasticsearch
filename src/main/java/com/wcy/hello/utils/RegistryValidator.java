package com.wcy.hello.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistryValidator {

    private static Logger logger = LoggerFactory.getLogger(RegistryValidator.class);

    public static RegistryValidatorModel getPIDByQRCode(String registry) {
        logger.debug("[Entry]" + " registry: " + registry);
        RegistryValidatorModel result = new RegistryValidatorModel();
        result.setContent(registry);
        result.setResult(registry);
        if (registry.isEmpty()) {
            return result;
        }
        String patternStr = "^http.*([0-9]{32}).*";
        if (!Pattern.matches(patternStr, registry)) {
            logger.debug("[Exit]" + "QRCode content does not match the pattern, can not pick up the PID. " + " result: " + result);
            return result;
        }
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(registry);
        String parsedRegistry = "";
        while (matcher.find()) {
            parsedRegistry = matcher.group(1);
        }
        if (parsedRegistry.isEmpty()) {
            logger.debug("[Exit]" + "QRCode content does not match the pattern, can not pick up the PID. " + " result: " + result);
            return result;
        }
        logger.debug("parsedRegistry:" + parsedRegistry);

        String pid = parsedRegistry.substring(0, 7);
        String pdType = pid.substring(0, 1);
        String prefix = "PD";
        if (pdType == "2") {
            prefix = "WP";
        }

        if (pdType == "3") {
            prefix = "LS";
        }
        pid = prefix + "20" + pid.substring(1, 6);
        result.setResult(pid);
        result.setContent(parsedRegistry.substring(0,11));
        result.setFullCode(parsedRegistry);
        logger.debug("[Exit]" + " result: " + result.toString());
        return result;
    }
}
