package com.wcy.hello.utils;

public class RegistryValidatorModel {
    private String content;
    private String fullCode;
    private String result;

    public RegistryValidatorModel() {
    }

    public RegistryValidatorModel(String content, String fullCode, String result) {
        this.content = content;
        this.fullCode = fullCode;
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                "content:'" + content + '\'' +
                ", fullCode:'" + fullCode + '\'' +
                ", result:'" + result + '\'' +
                '}';
    }
}
