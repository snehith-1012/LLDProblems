package com.LLD.LLD.Twitter;

public enum InteractionTypeEnum {

    LIKE("like"),
    COMMENT("comment");

    private String content;

    InteractionTypeEnum(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
