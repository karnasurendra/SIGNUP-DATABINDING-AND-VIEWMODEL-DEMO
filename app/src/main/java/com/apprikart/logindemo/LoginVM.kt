package com.apprikart.logindemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginVM : ViewModel() {

    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var confirmPassword = MutableLiveData<String>()
    var toastUpdate = MutableLiveData<String>()
    var intentUpdate = MutableLiveData<String>()

    companion object {
        const val EMPTY_MESSAGE = "Fields can't be empty!!"
        const val INVALID_EMAIL = "Please provide valid email address!!"
        const val PASSWORD_MISMATCH = "Password and Confirm Password should be same!!"
    }

    fun signUp() {
        if (firstName.value.isNullOrEmpty() ||
            lastName.value.isNullOrEmpty() ||
            email.value.isNullOrEmpty() || password.value.isNullOrEmpty() || confirmPassword.value.isNullOrEmpty()
        ) {
            toastUpdate.value = EMPTY_MESSAGE
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.value.toString()).matches()) {
            toastUpdate.value = INVALID_EMAIL
        } else if (password.value != confirmPassword.value) {
            toastUpdate.value = PASSWORD_MISMATCH
        } else {
            intentUpdate.value = "HOME"
        }
    }

}