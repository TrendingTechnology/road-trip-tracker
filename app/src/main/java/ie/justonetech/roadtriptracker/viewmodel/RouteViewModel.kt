package ie.justonetech.roadtriptracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import ie.justonetech.roadtriptracker.model.RouteDetail
import ie.justonetech.roadtriptracker.model.RouteSummary
import ie.justonetech.roadtriptracker.model.TrackingRepository

///////////////////////////////////////////////////////////////////////////////////////////////////
// RouteViewModel
// Route detail and route list model
///////////////////////////////////////////////////////////////////////////////////////////////////

class RouteViewModel(application: Application)
    : AndroidViewModel(application) {

    private val repository = TrackingRepository(application)
    private val currentRouteId = MutableLiveData<Int>()

    val routeList: LiveData<PagedList<RouteSummary>> by lazy {
        repository.getRouteList()
    }

    val routeDetail = Transformations.switchMap(currentRouteId) {
        if(currentRouteId.value != RouteDetail.INVALID_ID)
            repository.getRouteDetail(it)
        else
            repository.getLatestRoute()
    }

    fun fetchRouteDetail(routeId: Int) {
        currentRouteId.value = routeId
    }

    fun fetchLatestRouteDetail() {
        currentRouteId.value = RouteDetail.INVALID_ID
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    companion object {
        private val TAG = RouteViewModel::class.java.simpleName
    }
}