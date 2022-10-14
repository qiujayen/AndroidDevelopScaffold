package ads.view.recyclerview

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

/**
 * @author QiuJie
 */
abstract class IntKeyPagingSource<Value : Any> : PagingSource<Int, Value>() {
    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val key = params.key ?: startKey()
        return try {
            LoadResult.Page(
                load(key, params),
                prevKey = if (key == startKey()) null else key - 1,
                nextKey = key + 1
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    abstract suspend fun load(key: Int, params: LoadParams<Int>): List<Value>

    open fun startKey(): Int = 0
}