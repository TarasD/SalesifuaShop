package com.springapp.mvc.service;

import com.springapp.mvc.domain.Shop;
import com.springapp.mvc.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public List<Shop> getAll(int page, int amount, String field) {
        Sort sort = new Sort(Sort.Direction.ASC, field);
        PageRequest pageRequest = new PageRequest(page, amount, sort);
        return shopRepository.findAll(pageRequest).getContent();
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

    public List<Shop> findBy(String field, String value) {
        if(field.equals("name")) return shopRepository.findByName(value);
        else if(field.equals("address")) return shopRepository.findByAddress(value);
        else if(field.equals("email")) return shopRepository.findByEmail(value);
        else if(field.equals("phoneNumber")) return shopRepository.findByPhoneNumber(value);
        else if(field.equals("password")) return shopRepository.findByPassword(value);
        return null;
    }
}
