package org.wordpress.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import org.wordpress.android.viewmodel.Event

class CommentFullScreenDialogViewModel
@Inject constructor() : ViewModel() {
    private val _onKeyboardOpened = MutableLiveData<Event<Unit>>()
    val onKeyboardOpened: LiveData<Event<Unit>> = _onKeyboardOpened

    fun init() {
        _onKeyboardOpened.postValue(Event(Unit))
    }
}
