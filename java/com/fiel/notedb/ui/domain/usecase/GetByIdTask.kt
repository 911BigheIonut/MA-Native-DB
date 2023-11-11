package com.fiel.notedb.ui.domain.usecase

import com.fiel.notedb.ui.data.ReposityImpl
import javax.inject.Inject

class GetByIdTask @Inject constructor(private val reposityImpl: ReposityImpl) {
    suspend operator fun invoke(id:Int) = reposityImpl.getByIdTask(id)

}