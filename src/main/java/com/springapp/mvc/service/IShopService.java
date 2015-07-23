package com.springapp.mvc.service;

import com.springapp.mvc.domain.Shop;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by taras on 22.07.15.
 */
public interface IShopService {
    List<Shop> getAll(Sort sort);

    Shop getShop(Long id);

    Shop addShop(Shop shop);

    void deleteShop(Long id);

    List<Shop> findByName(String name);
}
