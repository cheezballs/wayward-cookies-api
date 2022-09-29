package us.mattroberts.waywardcookies.model.decode;

import lombok.Getter;

@Getter
public enum OrderStatus {
    SUBMITTED("SU"),
    ACCEPTED("AC"),
    WORKING_BAKED("WB"),
    WORKING_BASE_ICED("WI"),
    WORKING_DECORATED("WD"),
    WORKING_PACKAGED("WP"),
    SHIPPED("SH"),
    COMPLETED("CM"),
    CANCELLED("CA"),
    REJECTED("RE");
    private final String code;

    OrderStatus(String code) {
        this.code = code;
    }

    public static OrderStatus findForCode(String code) {
        for (OrderStatus status : values()) {
            if (code.equals(status.code)) {
                return status;
            }
        }
        return null;
    }
}