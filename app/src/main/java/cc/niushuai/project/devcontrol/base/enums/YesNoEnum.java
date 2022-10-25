package cc.niushuai.project.devcontrol.base.enums;

public enum YesNoEnum {

    YES("1", 1, "是"),
    NO("0", 0, "否"),
    ;

    private String value;
    private Integer integerValue;
    private String text;

    YesNoEnum(String value, Integer integerValue, String text) {
        this.value = value;
        this.integerValue = integerValue;
        this.text = text;
    }

    public static YesNoEnum matchByValue(String value) {
        for (YesNoEnum onOffEnum : YesNoEnum.values()) {
            if (onOffEnum.getValue().equals(value)) {
                return onOffEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public Integer getIntegerValue() {
        return integerValue;
    }

    public String getText() {
        return text;
    }
}
