# Beauty_Products.
## Reach PLC task.
Implementation of an app that lists all the beauty products and allows the user to read a detailed description of the product.
### Implementation.
For the development of this android app six JAVA classes were created along with four XML files described below.
### JAVA Classes.
#### MAinActivity Class.
Initializes the main activity layout.
```java
//sets content of the main activity layout
        setContentView(R.layout.activity_main);
//Initializes the tool bar in main activity
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
```
#### ListFragment Class.
Initializes the list fragmnet layout.
```java
//variables declaraion
        private ListViewModel mViewModel;
        private ListView lv;
    
//sets and inflates the list view on list fragment layout
        View view = inflater.inflate(R.layout.fragment_list,
                container, false);
        lv = view.findViewById(R.id.beautyProducts);
        
//calls the ViewModel class to observe the activity
        mViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);
        //set the array adapter for the list view
        lv.setAdapter(new ArrayAdapter<String>(this.getActivity(),
                R.layout.lv_custom_layout, mViewModel.getProductList())


        );
        
//sets a click listener on listview items, gets the string of the item clicked and sends it to the ViewModel
        lv.setOnItemClickListener((adapter, itemView, pos, id) -> {
            TextView tv = (TextView)itemView;
            Toast.makeText(this.getContext(), tv.getText().toString()+" Selected", Toast.LENGTH_SHORT).show();
            mViewModel.selectProduct(tv.getText().toString());

        });        
```
#### DetailsFragment Class.
Initializes the details fragmnet layout.
```java
//variables declaration
    private ListViewModel mViewModel;
    private TextView tname, tprice, tdescrip;
    public  TextView name_tv, price_tv;
    private ImageView pimage;
    
//calls the ViewModel class to observe the activity and get the selected product details
        mViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);
        mViewModel.getSelectedProduct().observe(this, item -> {
            displayDetails(mViewModel.getProductDetails(item));
        });
        
//sets the selected product details into variables
        tname.setText(product.getName());
        tprice.setText(String.format("%.2f", product.getPrice())+"€");
        tdescrip.setText(product.getDescrip());
        pimage.setImageResource(product.getImage());
        
//changes the visibility to true of the textviews for the price and name
        name_tv.setVisibility(View.VISIBLE);
        price_tv.setVisibility(View.VISIBLE);
        
//sets and inflates the objects within the details fragment layout
        View view = inflater.inflate(R.layout.fragment_detail,
                container, false);

        name_tv = view.findViewById(R.id.name_tv);
        price_tv = view.findViewById(R.id.price_tv);
        pimage = view.findViewById(R.id.productimage);
        tname = view.findViewById(R.id.productName);
        tprice = view.findViewById(R.id.productPrice);
        tdescrip = view.findViewById(R.id.productDescription);

        return view;       
```
#### ListViewModel class.
List view model that contains and shares live data.
```java
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
```
#### ProductRepository class.
This class contains valuable data being used in the app.
```java
//Method that returns array of products
    public String[] getProducts(){
        if(products == null){
            products = new String[3];
            products[0] = "Express Lipstick";
            products[1] = "Daily Eyeliner";
            products[2] = "RSVP Shampoo";
        }

        return products;
    }

//Method that checks for selected product value and calls method to retrieve that product detail
    public Product getProductDetails(String name){
        if(productDetails == null){
            createProductDetailsMap();
        }
        return productDetails.get(name);
    }

//method that creates a HasMap of the selected product and return the product details
    public void createProductDetailsMap(){
        productDetails = new HashMap<String, Product>();

        Product product = new Product();
        product.setName("Express Lipstick");
        product.setImage(R.mipmap.ic_lipstick_round);
        product.setPrice(22.00);
        product.setDescrip("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vehicula ipsum sit amet odio euismod aliquam. Aenean aliquam vestibulum nibh, tincidunt fringilla sapien posuere id. Suspendisse ut lacus vitae elit mollis sagittis ut id ligula. Curabitur rhoncus non orci a ultricies. Praesent lacinia nisi urna, ac pharetra purus ultricies a. Quisque ut felis vel massa lobortis aliquam eu vel erat. Quisque vestibulum massa erat, quis efficitur nunc blandit ac. Proin sit amet maximus turpis. Donec sodales enim ligula. Aenean et scelerisque odio. Pellentesque ut suscipit lorem. Quisque non dapibus arcu, ac commodo massa. Curabitur sed tortor a diam ultrices volutpat a sit amet turpis. Pellentesque sem erat, aliquam in nisi et, sollicitudin tincidunt diam.");
    }
```
#### Produc class.
This class contains handles how the date is get and set in the ProductRepository class.
```java
//Variables declaration
    private String name;
    private double price;
    private String descrip;
    private int image;
    
//Methods that sets and gets values of the product details to the repository class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }    
```
## Contributing
Pull requests are welcome. For any changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
© Angel De Sousa
