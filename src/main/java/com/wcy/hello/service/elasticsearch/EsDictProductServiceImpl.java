package com.wcy.hello.service.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.wcy.hello.model.elasticsearch.Dict_Product;
import com.wcy.hello.model.elasticsearch.Dict_Product_Addons_V;
import com.wcy.hello.repository.elasticsearch.EsDictProductRepo;
import com.wcy.hello.scheme.ListResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

@Service
public class EsDictProductServiceImpl implements EsDictProductService {

    private EsDictProductRepo esDictProductRepo;

    @Autowired
    public void setEsDictProductRepo(EsDictProductRepo esDictProductRepo) {
        this.esDictProductRepo = esDictProductRepo;
    }

    @Override
    public ListResult search(QueryBuilder queryBuilder, Pageable pageable) {
        ListResult<Dict_Product> listResult = new ListResult();
        Page<Dict_Product> result = esDictProductRepo.search(queryBuilder, pageable);
        listResult.setTotal(result.getTotalElements());
        List<Dict_Product> _result = result.getContent();
        try{
            for (Dict_Product dict_product: _result) {
                Object addons = dict_product.getAddons();
                for (Object addon: (List)addons) {
                    Class clazz = addon.getClass();
                    Method getMethod = clazz.getDeclaredMethod("get", Object.class);
                    Object value = getMethod.invoke(addon, "v");
                    List<String> list = new LinkedList<>();
                    try {
                        list = JSON.parseArray(value.toString(), String.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                    if (list instanceof List) {
                        ArrayList<Dict_Product_Addons_V> addonsList = new ArrayList<>();
                        for (Object obj: list) {
                            Dict_Product_Addons_V addons_v = JSON.parseObject(obj.toString(), Dict_Product_Addons_V.class);
                            addonsList.add(addons_v);
                        }
                        ((HashMap)addon).put("v", addonsList);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        listResult.setList(_result);
        return listResult;
    }

    @Override
    public Dict_Product searchRegistry(QueryBuilder queryBuilder, Pageable pageable) {
        ListResult<Dict_Product> listResult = new ListResult();
        Page<Dict_Product> result = esDictProductRepo.search(queryBuilder, pageable);
        List<Dict_Product> _result = result.getContent();
        Dict_Product dict_product = new Dict_Product();
        if (_result.size() > 0) {
            dict_product = _result.get(0);
        }
        return dict_product;
    }
}
