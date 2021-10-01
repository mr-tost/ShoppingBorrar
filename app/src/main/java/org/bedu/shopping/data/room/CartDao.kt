package com.example.beducompras.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.bedu.shopping.data.model.Product

@Dao
interface CartDao {

    @Insert
    fun insert(product: Product)

    @Delete
    suspend fun delete(product: Product)

    @Query("SELECT * FROM product_cart")
    suspend fun getCart(): List<Product>


    @Query("INSERT INTO product_cart (id,title,price,description,category,image)  SELECT id,title,price,description,category,image FROM product_cart WHERE localId=:localId")
    suspend fun addCartQuantity(localId: Int)

    @Query("DELETE FROM product_cart WHERE localId in (SELECT localId FROM product_cart WHERE id=:id LIMIT 1)")
    suspend fun removeCartQuantity(id: Int)

    @Query("DELETE FROM product_cart WHERE id=:id")
    suspend fun removeCartProduct(id: Int)


    @Query("DELETE FROM product_cart")
    suspend fun deleteAll()

}