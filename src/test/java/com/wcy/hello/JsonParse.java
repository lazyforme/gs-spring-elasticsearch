package com.wcy.hello;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class JsonParse {
    public static void main(String[] args) {
        String json1 = "[{\"active_ingredient\":\"\",\"crop\":\"黄瓜（保护地）\",\"id\":\"259823\",\"ingredient_content\":\"\",\"insect_control\":\"白粉虱\",\"method\":\"喷雾\",\"product_id\":\"18971\",\"usage_amount\":\"90－150克/公顷\"},{\"active_ingredient\":\"\",\"crop\":\"黄瓜（保护地）\",\"id\":\"259824\",\"ingredient_content\":\"\",\"insect_control\":\"蓟马\",\"method\":\"喷雾\",\"product_id\":\"18971\",\"usage_amount\":\"60－120克/公顷\"},{\"active_ingredient\":\"\",\"crop\":\"水稻\",\"id\":\"259825\",\"ingredient_content\":\"\",\"insect_control\":\"二化螟\",\"method\":\"喷雾\",\"product_id\":\"18971\",\"usage_amount\":\"90－150克/公顷\"},{\"active_ingredient\":\"\",\"crop\":\"水稻\",\"id\":\"259826\",\"ingredient_content\":\"\",\"insect_control\":\"飞虱\",\"method\":\"喷雾\",\"product_id\":\"18971\",\"usage_amount\":\"60－120克/公顷\"}]";
        List<String> list = JSON.parseArray(json1, String.class);
        System.out.println(list.size());

        String str2 = "有毒";
        List<String> list2 = JSON.parseArray(str2, String.class);
        System.out.println(list2.size());
    }
}
