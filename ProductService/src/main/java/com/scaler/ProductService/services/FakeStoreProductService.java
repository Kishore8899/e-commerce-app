package com.scaler.ProductService.services;

import com.scaler.ProductService.dtos.FakeStoreProductResponseDto;
import com.scaler.ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements  ProductService{

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public Product GetProductById(Long id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductResponseDto.class);
        if(fakeStoreProductResponseDto==null){return null;}
        return  fakeStoreProductResponseDto.toProduct();
    }
}
