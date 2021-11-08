package com.barista.latte.auth

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.barista.latte.auth.model.LoginStatus
import com.barista.latte.auth.model.SignInRequestObject
import com.barista.latte.auth.model.TokenObject
import com.barista.latte.common.RetrofitObject
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/*
* Created by Juhyang on 2021/10/30
*/


@Singleton
class UserRepository @Inject constructor(@ApplicationContext val context: Context) {

    private object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }


    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "tokens")

    private val accessTokenFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.ACCESS_TOKEN] ?: ""
    }
    val accessToken : String get() {
        return runBlocking(Dispatchers.IO) {
            accessTokenFlow.first()
        }
    }
    private val refreshTokenFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.REFRESH_TOKEN] ?: ""
    }
    val refreshToken : String get() {
        return runBlocking(Dispatchers.IO) {
            refreshTokenFlow.first()
        }
    }

    suspend fun signInByEmail(email : String, password : String) : LoginStatus {
        val loginResponse = RetrofitObject.getAuthServerInterface().signIn(SignInRequestObject(email, password))
        if (loginResponse.isSuccessful) {
            val tokenObject: TokenObject = loginResponse.body()!!

            writeAccessTokenToDataStore(tokenObject.accessToken)
            writeRefreshTokenToDataStore(tokenObject.refreshToken)

            return LoginStatus.SUCCESS
        } else {
            Timber.e("#juhyang error : ${loginResponse.errorBody()?.string()}")
        }

        return LoginStatus.FAIL
    }

    suspend fun refreshTokenWithServer(onRefresh : () -> Unit) {
        val tokenResponse = RetrofitObject.getAuthServerInterface().refreshToken(TokenObject(accessToken, refreshToken))

        if (tokenResponse.isSuccessful) {
            val tokenObject: TokenObject = tokenResponse.body()!!

            writeAccessTokenToDataStore(tokenObject.accessToken)
            writeRefreshTokenToDataStore(tokenObject.refreshToken)

            onRefresh()
        }
    }

    private suspend fun writeAccessTokenToDataStore(accessToken: String) {
        context.dataStore.edit { tokens ->
            tokens[PreferencesKeys.ACCESS_TOKEN] = accessToken
        }
    }

    private suspend fun writeRefreshTokenToDataStore(refreshToken: String) {
        context.dataStore.edit { tokens ->
            tokens[PreferencesKeys.REFRESH_TOKEN] = refreshToken
        }
    }
}
