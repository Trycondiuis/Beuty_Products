package com.example.beautyproducts;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {
    //List view model that contains live data object
    private final MutableLiveData<String> selectedProduct = new MutableLiveData<String>();
    private ProductRepository repository = new ProductRepository();

    //methods to set value on live data object
    public void selectProduct(String productName) {
        selectedProduct.setValue(productName);
    }

    public MutableLiveData<String> getSelectedProduct() {
        return selectedProduct;
    }

    //methods providing product list and details.
    public String[] getProductList(){
        return repository.getProducts();
    }

    public Product getProductDetails(String name){
        return repository.getProductDetails(name);
    }
}
