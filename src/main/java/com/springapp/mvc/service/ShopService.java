package com.springapp.mvc.service;

import com.springapp.mvc.domain.Shop;
import com.springapp.mvc.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by taras on 22.07.15.
 */
@Service("shopService")
public class ShopService implements IShopService{

    @Autowired
    private ShopRepository shopRepository;

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public Shop getShop(Long id) {
        return shopRepository.findOne(id);
    }

    public Shop addShop(Shop shop) {
        return null;
    }

    public void deleteShop(Long id) {

    }

    public Shop updateShop(Shop shop) {
        return null;
    }
}
