package pl.vrajani.utility;

import org.apache.commons.lang3.StringUtils;

public class ValueParser {

    public static Double parseDoubleWithNulls(String value){
        return StringUtils.isNotBlank(value)? Double.parseDouble(value) : 0.0;
    }
}
