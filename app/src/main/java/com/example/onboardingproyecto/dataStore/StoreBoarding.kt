package com.example.onboardingproyecto.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.edit


class StoreBoarding(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("storeBoarding")
        val STORE_BOARDING = booleanPreferencesKey("store_boar")
    }

    val getBoarding = context.dataStore.data
        .map { preferences ->
            preferences[STORE_BOARDING] ?: false
        }

    suspend fun saveBoarding(store: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[STORE_BOARDING] = store // Corregido el uso del parámetro `store` en lugar de `value`
        }
    }
}
