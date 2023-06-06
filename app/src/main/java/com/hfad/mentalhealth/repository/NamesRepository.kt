package com.hfad.mentalhealth.repository

import com.hfad.mentalhealth.api.ApiServices
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NamesRepository @Inject constructor(
    private val api: ApiServices) {
    suspend fun getNames() = api.getNamesList()
}