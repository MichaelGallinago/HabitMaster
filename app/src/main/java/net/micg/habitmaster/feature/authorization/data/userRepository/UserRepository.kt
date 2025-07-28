package net.micg.habitmaster.feature.authorization.data.userRepository

import net.micg.habitmaster.feature.authorization.data.model.SignInData

interface UserRepository {
    suspend fun getUserData(): SignInData
    suspend fun clearUserData()
    suspend fun setUserData(data: SignInData)
}
