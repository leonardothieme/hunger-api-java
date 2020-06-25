package com.hunger.common.model;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Internal resource used in Product context.")
public class EnumResource<T extends Enum<T>> {

    @JsonIgnore
    private final T resource;
    @JsonIgnore
    private final MessageSource messageSource;

    private String value;

    @ApiModelProperty("Value that need to be send in back-end.")
    public String getValue() {
        return null != value ? value : resource.toString();
    }

    @ApiModelProperty("Label with internationalization.")
    public String getLabel() {
        return messageSource.getMessage(generateCode(), null, LocaleContextHolder.getLocale());
    }

    public EnumResource<T> value(Object value) {
        setValue(String.valueOf(value));
        return this;
    }

    private String generateCode() {
        final StringBuilder sb = new StringBuilder();
        sb.append(camelCaseForClass());
        sb.append(".");
        sb.append(camelCase(resource.toString(), "_"));
        return sb.toString();
    }

    private String camelCaseForClass() {
        String className = resource.getClass().getSimpleName();
        final StringBuilder sb = new StringBuilder();
        sb.append(className.substring(0, 1).toLowerCase());
        sb.append(className.substring(1));
        return sb.toString();
    }

    private String camelCase(String source, String delimiter) {
        final StringBuilder sb = new StringBuilder();
        sb.append(source.substring(0, 1).toLowerCase());
        sb.append(null != delimiter && source.contains(delimiter) ? source.substring(1, source.indexOf(delimiter)).toLowerCase()
                : source.substring(1).toLowerCase());

        if (null != delimiter && source.contains(delimiter)) {
            String[] inner = source.substring(source.indexOf(delimiter) + 1).split(delimiter);

            for (String content : inner) {
                sb.append(content.substring(0, 1).toUpperCase());
                sb.append(content.substring(1).toLowerCase());
            }
        }

        return sb.toString();
    }

}
