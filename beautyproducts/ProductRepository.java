package com.example.beautyproducts;

import java.util.HashMap;

public class ProductRepository {
    private String[] products;
    private HashMap<String, Product> productDetails;
    public String[] getProducts(){
        if(products == null){
            products = new String[3];
            products[0] = "Express Lipstick";
            products[1] = "Daily Eyeliner";
            products[2] = "RSVP Shampoo";
        }

        return products;
    }
    public Product getProductDetails(String name){
        if(productDetails == null){
            createProductDetailsMap();
        }
        return productDetails.get(name);
    }
    public void createProductDetailsMap(){
        productDetails = new HashMap<String, Product>();

        Product product = new Product();
        product.setName("Express Lipstick");
        product.setImage(R.mipmap.ic_lipstick_round);
        product.setPrice(22.00);
        product.setDescrip("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vehicula ipsum sit amet odio euismod aliquam. Aenean aliquam vestibulum nibh, tincidunt fringilla sapien posuere id. Suspendisse ut lacus vitae elit mollis sagittis ut id ligula. Curabitur rhoncus non orci a ultricies. Praesent lacinia nisi urna, ac pharetra purus ultricies a. Quisque ut felis vel massa lobortis aliquam eu vel erat. Quisque vestibulum massa erat, quis efficitur nunc blandit ac. Proin sit amet maximus turpis. Donec sodales enim ligula. Aenean et scelerisque odio. Pellentesque ut suscipit lorem. Quisque non dapibus arcu, ac commodo massa. Curabitur sed tortor a diam ultrices volutpat a sit amet turpis. Pellentesque sem erat, aliquam in nisi et, sollicitudin tincidunt diam.");

        productDetails.put("Express Lipstick", product);

        product = new Product();
        product.setName("Daily Eyeliner");
        product.setImage(R.mipmap.ic_eyeliner_round);
        product.setPrice(50.00);
        product.setDescrip("Aliquam erat volutpat. Suspendisse volutpat, risus nec pharetra porttitor, sem turpis pretium tellus, sit amet placerat massa est nec ipsum. Ut luctus lacus non cursus dictum. Maecenas tempor nisl ac tempor porttitor. Fusce gravida urna ac nibh efficitur, sit amet sollicitudin turpis fringilla. Duis malesuada ornare nunc eget feugiat. Sed bibendum massa ac blandit aliquam. Curabitur aliquam tincidunt urna vitae aliquet. Praesent posuere urna sit amet metus euismod, in ullamcorper arcu euismod. Aliquam at justo hendrerit, egestas orci in, cursus velit. Vivamus sollicitudin arcu in finibus semper. Fusce augue neque, consequat nec dui sed, iaculis scelerisque lorem. Pellentesque eu ipsum tincidunt, bibendum ante at, ornare nunc. Morbi imperdiet dignissim rutrum. Aliquam suscipit dolor sed orci tempor, vel sodales elit varius. Donec ultricies fringilla est.");

        productDetails.put("Daily Eyeliner", product);

        product = new Product();
        product.setName("RSVP Shampoo");
        product.setImage(R.mipmap.ic_shampoo_round);
        product.setPrice(35.50);
        product.setDescrip("In pharetra ex eu tempus pulvinar. Mauris velit eros, sollicitudin in lobortis non, pulvinar sit amet nisi. Nam justo est, mollis quis lacus et, rhoncus rutrum massa. Morbi purus urna, molestie nec dapibus sit amet, pharetra ac sem. Nullam semper mi id elit efficitur, eget egestas felis tincidunt. Nam id libero id nisl viverra lobortis ac eget orci. Donec consectetur tincidunt turpis, luctus ornare dolor hendrerit ut. Nam ex ante, tempus eget tortor vel, mattis aliquam ante. Etiam in dapibus massa, non aliquet elit. Vestibulum volutpat gravida justo in aliquet. Aenean vitae eleifend tortor, sed pharetra leo. Fusce porta turpis leo, vitae blandit mi maximus sit amet. Aenean laoreet sem sed felis interdum ullamcorper. Duis elementum elementum ornare.");

        productDetails.put("RSVP Shampoo", product);
    }
}
