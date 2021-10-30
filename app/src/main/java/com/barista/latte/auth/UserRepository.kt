package com.barista.latte.auth

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

/*
* Created by Juhyang on 2021/10/30
*/


class UserRepository @Inject constructor(@ApplicationContext val context: Context) {

    private object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }


    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "tokens")

    val accessTokenFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.ACCESS_TOKEN] ?: ""
    }
    val refreshTokenFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.REFRESH_TOKEN] ?: ""
    }

    suspend fun writeAccessTokenToDataStore(accessToken: String) {
        context.dataStore.edit { tokens ->
            tokens[PreferencesKeys.ACCESS_TOKEN] = accessToken
        }
    }

    suspend fun writeRefreshTokenToDataStore(refreshToken: String) {
        context.dataStore.edit { tokens ->
            tokens[PreferencesKeys.REFRESH_TOKEN] = refreshToken
        }
    }
}
