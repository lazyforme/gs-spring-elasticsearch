package com.wcy.hello.model.elasticsearch;

public class Dict_Product_Addons_V {
    private String id = "";
    private String product_id = "";
    private String crop = "";
    private String insect_control = "";
    private String usage_amount = "";
    private String method = "";
    private String active_ingredient = "";
    private String ingredient_content = "";

    public Dict_Product_Addons_V() {
    }

    public Dict_Product_Addons_V(String id, String product_id, String crop, String insect_control, String usage_amount, String method, String active_ingredient, String ingredient_content) {
        this.id = id;
        this.product_id = product_id;
        this.crop = crop;
        this.insect_control = insect_control;
        this.usage_amount = usage_amount;
        this.method = method;
        this.active_ingredient = active_ingredient;
        this.ingredient_content = ingredient_content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getInsect_control() {
        return insect_control;
    }

    public void setInsect_control(String insect_control) {
        this.insect_control = insect_control;
    }

    public String getUsage_amount() {
        return usage_amount;
    }

    public void setUsage_amount(String usage_amount) {
        this.usage_amount = usage_amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getActive_ingredient() {
        return active_ingredient;
    }

    public void setActive_ingredient(String active_ingredient) {
        this.active_ingredient = active_ingredient;
    }

    public String getIngredient_content() {
        return ingredient_content;
    }

    public void setIngredient_content(String ingredient_content) {
        this.ingredient_content = ingredient_content;
    }
}
