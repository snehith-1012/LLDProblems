package com.LLD.LLD.stackOverflow;

public class Tag {

    private int id;

    private String tagName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Tag(String tagName){
        this.tagName = tagName;
        this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
