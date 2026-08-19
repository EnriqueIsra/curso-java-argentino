package com.enrique.cloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import com.enrique.cloud.msvc.items.models.Item;
import com.enrique.cloud.msvc.items.models.Product;

public interface ItemService {

    List<Item> findAll();

    Optional<Product> findById(Long id);
}
