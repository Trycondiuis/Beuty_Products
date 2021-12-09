# Beauty_Products.
## Reach PLC task.
Implementation of an app that lists all the beauty products and allows the user to read a description of the product, in more detail.
### Implementation.
For the development of this android app six JAVA classes were created along with three XML files described below.
### JAVA Classes.
MAinActivity Class.
It sets the main activity layout and the tool bar added to display the app name.
```java
//sets content of the main activity layout
setContentView(R.layout.activity_main);
  //instantiate the tool bar in main activity
Toolbar tb = findViewById(R.id.toolbar);
setSupportActionBar(tb);
```
