package us.mattroberts.waywardcookies.model.decode;

import lombok.Getter;

@Getter
public enum LogisticsType {
    DELIVERY("D"),
    SHIPPING("S");
    private final String code;

    LogisticsType(String code) {
        this.code = code;
    }

    public static LogisticsType findForCode(String code) {
        for (LogisticsType status : values()) {
            if (code.equals(status.code)) {
                return status;
            }
        }
        return null;
    }
}