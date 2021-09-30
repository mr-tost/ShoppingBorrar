package org.bedu.shopping.util

class NetworkFailedError(message: String, cause: Throwable?) : Throwable(message, cause)
class NetworkConnectionError(message: String, cause: Throwable?) : Throwable(message, cause)