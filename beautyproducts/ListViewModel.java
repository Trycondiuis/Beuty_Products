package com.example.beautyproducts;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {
    private final MutableLiveData<String> selectedProduct = new MutableLiveData<String>();
    private ProductRepository repository = new ProductRepository();

    public void selectProduct(String productName) {
        selectedProduct.setValue(productName);
    }

    public MutableLiveData<String> getSelectedProduct() {
        return selectedProduct;
    }

    public String[] getProductList(){
        return repository.getProducts();
    }

    public Product getProductDetails(String name){
        return repository.getProductDetails(name);
    }
}
