# product-catalog-service
```Response status ``` </br>
`200 : Ok` </br>
`204 : No Content` </br>
'400' : Bad request

### Brand resource
##### Add brand

`POST`
`uri : http://localhost:8080/mycart/brand `</br>
```body
{
"name" : "name",
"description" : "description"
}
```


##### Get brand

`GET`
`uri : http://localhost:8080/mycart/brand/{brandId} `</br>

##### Delete brand

`DELETE`
`uri : http://localhost:8080/mycart/brand/{brandId} `</br>


### Category resource
##### Add category

`POST`
`uri : http://localhost:8080/mycart/category ` </br>
``` body :
{
"name" : "name",
"description" : "description",
"brandId" : brandid
}
```

`GET`
`uri : http://localhost:8080/mycart/category/{categoryId} ` </br>

### Product resource
##### Add Product

`POST`
`http://localhost:8080/mycart/productcatalog/product` </br>
```body
{
"name" : "name",
"description" : "description",
"categoryId" : categoryId,
"brandId" : brandId,
}
```

##### Get Product

`GET`
`http://localhost:8080/mycart/productcatalog/product/{productId}` </br>

##### Get all Products

`GET`
`http://localhost:8080/mycart/productcatalog/product/all` </br>

##### Delete Product
``DELETE
`http://localhost:8080/mycart/productcatalog/product/{productId}` </br>


### Product Search

`Get product by Search crieteria`

`http://localhost:8080/mycart/productcatalog/product/search?crieteria=`
`crieteria = brand:brandname,category:category,brand:brand,size:size,size<=>size,sku<=>sku `


