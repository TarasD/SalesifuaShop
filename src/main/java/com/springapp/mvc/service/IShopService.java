package com.springapp.mvc.service;

import com.springapp.mvc.domain.Shop;

import java.util.List;

/**
 * Created by taras on 22.07.15.
 */
public interface IShopService {
    List<Shop> getAll(int page, int amount, String field);

    Shop getShop(Long id);

    Shop addShop(Shop shop);

    void deleteShop(Long id);

    List<Shop> findBy(String field, String value);
}
