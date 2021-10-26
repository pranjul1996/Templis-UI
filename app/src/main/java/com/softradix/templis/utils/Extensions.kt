package com.softradix.templis.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.Spannable
import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * start activity inlined function
 *
 */

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}

//fun getDeviceToken() {
//    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//        if (!task.isSuccessful) {
//            Log.w("TAG", "Fetching FCM registration token failed", task.exception)
//            return@OnCompleteListener
//        }
//        // Get new FCM registration token
//        val token = task.result
//        Log.e("TAG", "getDeviceToken: $token")
//
//        Preferences.prefs?.saveValue(Constants.DEVICE_TOKEN, token)
//    })
//}

// show toast on activity
fun Activity.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// show toast on Fragment
fun Fragment.toast(message: String?) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}

// show toast on Fragment
fun Fragment.toastOnCenter(message: String?) {
    val toast = Toast.makeText(activity, message, Toast.LENGTH_LONG)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
}

// view gone
fun View.makeGone() {
    this.visibility = View.GONE
}

// view gone
fun View.makeInVisible() {
    this.visibility = View.INVISIBLE
}

// view Visible
fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun hideKeyBoard(activity: Activity) {
    val inputManager = activity.getSystemService(
        Context.INPUT_METHOD_SERVICE
    ) as InputMethodManager
    val focusedView = activity.currentFocus
    if (focusedView != null) {
        inputManager.hideSoftInputFromWindow(
            focusedView.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}



fun getDayFormattedDate(smsTimeInMilis: Long): String {
    val smsTime: Calendar = Calendar.getInstance()
    smsTime.timeInMillis = smsTimeInMilis
    val now: Calendar = Calendar.getInstance()
    return when {
        now.get(Calendar.DATE) == smsTime.get(Calendar.DATE) -> {
            "Today"
        }
        now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1 -> {
            "Yesterday"
        }
//        now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) > 1
        (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) in 2..5) -> { //greater than 1 less than 7
            "This Week"
        }
        now.get(Calendar.MONTH) == smsTime.get(Calendar.MONTH) -> {
            "This Month"
        }
        else -> {
            "Earlier"
        }
    }
}


fun dateToTimeStamp(str_date: String?): Long {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val date = inputFormat.parse(str_date ?: "") as Date
    return date.time
}

fun formattedResult(value: Double): String { //#,###.00
    val formatter = DecimalFormat("#####.##")
    return NumberFormat.getNumberInstance(Locale.US).format(value)
//    return formatter.format(value)
}

fun setSpannableText(firstWord: String, lastWord: String, textView: TextView) {
    val spannable: Spannable = SpannableString(firstWord + lastWord)
    spannable.setSpan(
        RelativeSizeSpan(0.8f),
        0,
        firstWord.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    ) // set size

    spannable.setSpan(
        RelativeSizeSpan(0.4f),
        firstWord.length,
        firstWord.length + lastWord.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    ) // set size

    textView.text = spannable
}
