package com.ly.mylifecycle

import android.app.SearchManager
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryOwner


class SearchManager(registryOwner: SavedStateRegistryOwner) : SavedStateRegistry.SavedStateProvider {
    companion object {
        private const val PROVIDER = "search_manager"
        private const val QUERY = "query"
    }

    private var query: String? = null
    var TAG = "SearchManager"

    init {
        // Register a LifecycleObserver for when the Lifecycle hits ON_CREATE
        registryOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_CREATE) {
                val registry = registryOwner.savedStateRegistry

                // Register this object for future calls to saveState()
                registry.registerSavedStateProvider(PROVIDER, this)

                // Get the previously saved state and restore it
                val state = registry.consumeRestoredStateForKey(PROVIDER)

                // Apply the previously saved state
                query = state?.getString(QUERY)
                Log.d(TAG, "query: $query")
            }
        })
    }

    override fun saveState(): Bundle {
        Log.d(TAG, "saveState--->")
        val bundle = Bundle()
        bundle.putString(SearchManager.QUERY, "query test")
        return bundle
    }

}

//class SearchFragment : Fragment() {
//    private var searchManager = SearchManager(this)
//}