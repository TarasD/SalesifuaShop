package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by taras on 22.07.15.
 */
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByName(String name);
}
