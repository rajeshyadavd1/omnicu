1. CRUD Operations on product:

    END POINT 1: http://localhost:8001/omnicuris/product/save
                 For post the details into database 
                {
	                "pname":"saridon",
	                "price":"2",
	                "qty":3
                }
    END POINT 2: http://localhost:8001/omnicuris/product/{id}
                 by using this endpoint get the product details by using product id
                 
    END POINT 3: http://localhost:8001/omnicuris/product/all
                 By using this endpoint get all product details 
                 
    END POINT 4: http://localhost:8001/omnicuris/product/update/{id}  
                 by using this end point update the product details
                 
    END POINT 5: http://localhost:8001/omnicuris/product/delete/{id}
                 by using this endpoint delete the product details
    
2.    
