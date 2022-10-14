package ads.view.recyclerview

import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * @author QiuJie
 */
abstract class CommonPagingSource<Value : Any> : PagingSource<Int, Value>() {
    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}