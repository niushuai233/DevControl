package cc.niushuai.project.devcontrol.base.enums;

public enum OnOffEnum {

    ON("ON", "开"),
    OFF("OFF", "关"),
    ;

    private String value;
    private String text;

    OnOffEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public static OnOffEnum matchByValue(String value) {
        for (OnOffEnum onOffEnum : OnOffEnum.values()) {
            if (onOffEnum.getValue().equals(value)) {
                return onOffEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
