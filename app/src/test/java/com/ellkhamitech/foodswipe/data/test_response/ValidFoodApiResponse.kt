package com.ellkhamitech.foodswipe.data.test_response

/**
 * Created by A.Elkhami on 01,May,2022
 */

val validFoodResponse = """
   [
   {
      "id":"1",
      "name":"name",
      "description":"test",
      "products":[
         {
            "id":"1",
            "categoryId":"2",
            "name":"Orange",
            "url":"/image.jpg",
            "description":"desc",
            "salePrice":{
               "amount":"10",
               "currency":"EGP"
            }
         },
         {
            "id":"2",
            "categoryId":"1",
            "name":"Apple",
            "url":"",
            "description":"dec",
            "salePrice":{
               "amount":"10",
               "currency":"EGP"
            }
         }
      ]
   }
]
""".trimIndent()