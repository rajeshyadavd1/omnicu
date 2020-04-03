1. CRUD Operations on product:

    END POINT 1: http://localhost:8001/omnicuris/item/save
                 For post the details into database 
                {
	                "pname":"saridon",
	                "price":"2",
	                "qty":3
                }
    END POINT 2: http://localhost:8001/omnicuris/item/{id}
                 by using this endpoint get the product details by using product id
                 
    END POINT 3: http://localhost:8001/omnicuris/item/all
                 By using this endpoint get all product details 
                 
    END POINT 4: http://localhost:8001/omnicuris/item/update/{id}  
                 by using this end point update the product details
                 
    END POINT 5: http://localhost:8001/omnicuris/item/delete/{id}
                 by using this endpoint delete the product details
    
2. GET ALL ITEMS LIST

    END POINT: http://localhost:8001/omnicuris/item/all
 
3. SINGLE ORDER

    END POINT: http://localhost:8001/omnicuris/order/place/{EMAIL}
    [
    	{
		"item":{
			"id":2
		},
		"qty":1
	}
    ]
    
4. BULK ORDER

    END POINT: http://localhost:8001/omnicuris/order/place/{EMAIL}
    
  [
	{
		"item":{
			"id":1
	},
	"qty":2
	},
	
	{
		"item":{
			"id":2
		},
		"qty":1
	}
  ]

5. ALL ORDERS

    END POINT: http://localhost:8001/omnicuris/order/all

