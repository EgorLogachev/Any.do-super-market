package com.example.superdomarket.data

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener


class ProductsProviderImpl : ProductsProvider {

    companion object {
        const val WS_URL = "wss://superdo-groceries.herokuapp.com/receive";
    }

    private val client = OkHttpClient()
    private val request = Request.Builder().url(WS_URL).build()

    override suspend fun connect(): Flow<Product> {
        return channelFlow {
            val listener = object: WebSocketListener() {

                override fun onMessage(webSocket: WebSocket, text: String) {
                    super.onMessage(webSocket, text)

                    launch {
                        val moshi = Moshi.Builder().build()
                        val adapter: JsonAdapter<Product> = moshi.adapter(Product::class.java)
                        val product = adapter.fromJson(text)
                        send(product!!)
                    }
                }
            }
            client.newWebSocket(request, listener)
        }
    }
}

interface ProductsProvider {
    suspend fun connect(): Flow<Product>
}