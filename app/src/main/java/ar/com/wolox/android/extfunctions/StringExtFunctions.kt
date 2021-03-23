package ar.com.wolox.android.extfunctions

fun String.isValidEmail(): Boolean = this?.let { android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches() }