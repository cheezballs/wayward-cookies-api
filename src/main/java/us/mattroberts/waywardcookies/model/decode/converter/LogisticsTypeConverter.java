package us.mattroberts.waywardcookies.model.decode.converter;

import us.mattroberts.waywardcookies.model.decode.LogisticsType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class LogisticsTypeConverter implements AttributeConverter<LogisticsType, String> {

    @Override
    public String convertToDatabaseColumn(LogisticsType logisticsType) {
        if (logisticsType == null) {
            return null;
        }
        return logisticsType.getCode();
    }

    @Override
    public LogisticsType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(LogisticsType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}