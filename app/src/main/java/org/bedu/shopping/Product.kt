package org.bedu.shopping

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlin.random.Random


@Entity(tableName="product_cart")
@Parcelize
data class Product(
    @PrimaryKey(autoGenerate = true) val localId: Int,
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,

    ) : Parcelable
