package com.devtides.stackoverflowquery.model

import android.icu.text.DateFormat
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.text.Html
import com.google.gson.annotations.SerializedName
import java.util.*

data class ResponseWrapper<T> (
    val items : List<T>
)

data class Question(
    @SerializedName("question_id")
    val questionId : Int?,

    val title : String?,
    var score : String?,

    @SerializedName("creation_date")
    var date : Long?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(questionId)
        parcel.writeString(title)
        parcel.writeString(score)
        parcel.writeValue(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}

fun convertTitle(title: String?) =
    if(Build.VERSION.SDK_INT >= 24)
        Html.fromHtml(title, Html.FROM_HTML_MODE_LEGACY).toString()
    else
        Html.fromHtml(title).toString()


fun getDate(timeStamp : Long?) : String {
    var time = ""
    timeStamp?.let {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timeStamp * 1000
        time = android.text.format.DateFormat.format("dd-MM-yyyy hh:mm:ss", cal).toString()
    }

    return time
}