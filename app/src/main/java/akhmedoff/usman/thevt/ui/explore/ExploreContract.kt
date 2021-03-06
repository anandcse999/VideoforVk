package akhmedoff.usman.thevt.ui.explore

import akhmedoff.usman.data.model.Catalog
import akhmedoff.usman.data.model.CatalogItem
import android.arch.lifecycle.LifecycleOwner
import android.arch.paging.PagedList

interface ExploreContract {

    interface View : LifecycleOwner {
        var presenter: Presenter

        fun showLoading()

        fun hideLoading()

        fun showErrorLoading()

        fun setList(items: PagedList<Catalog>)

        fun showAlbum(album: CatalogItem, view: android.view.View)

        fun startSearch()

        fun showVideo(item: CatalogItem, view: android.view.View)
    }

    interface Presenter {
        var view: View?

        fun onCreated()

        fun onRetained()

        fun searchClicked()

        fun onDestroyed()

        fun refresh()

        fun onCatalogItemClicked(item: CatalogItem)
    }
}