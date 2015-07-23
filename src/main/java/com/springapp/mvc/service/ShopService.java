package com.springapp.mvc.service;

import com.springapp.mvc.domain.Shop;
import com.springapp.mvc.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by taras on 22.07.15.
 */
@Service("shopService")
public class ShopService implements IShopService{

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAll(Sort sort) {
        return shopRepository.findAll(sort);
    }

    public Shop getShop(Long id) {
        return shopRepository.findOne(id);
    }

    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    public void deleteShop(Long id) {
        shopRepository.delete(id);
    }

    public List<Shop> findByName(String name) {
        return shopRepository.findByName(name);
    }
}
