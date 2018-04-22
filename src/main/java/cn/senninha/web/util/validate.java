package cn.senninha.web.util;

import com.mysql.jdbc.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.mysql.jdbc.StringUtils;

public class validate {

    private final static boolean match(String text, String reg) {
        if (StringUtils.isEmptyOrWhitespaceOnly(text) || StringUtils.isEmptyOrWhitespaceOnly(reg))
            return false;
        return Pattern.compile(reg).matcher(text).matches();
    }
    public final static boolean isMobile(String text){
        if(text.length()!=11) return false;
        return match(text, "^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }
    public final static boolean isPwd(String str) {
        return match(str, "^[a-zA-Z]\\w{6,12}$");
    }
    public final static boolean isTel(String text){
        if(isMobile(text)||isPhone(text)) return true;
        return false;
    }
    public final static boolean isPhone(String text){
        return match(text, "^(\\d{3,4}-?)?\\d{7,9}$");
    }
}
