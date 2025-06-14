package pe.com.master.machines.common.response

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val error: ErrorType) : Resource<T>()
}