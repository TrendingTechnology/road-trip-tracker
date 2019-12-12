package ie.justonetech.roadtriptracker.utils

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ie.justonetech.roadtriptracker.R

///////////////////////////////////////////////////////////////////////////////////////////////////
// ProfileType
// Supported profile types and metadata
///////////////////////////////////////////////////////////////////////////////////////////////////

enum class ProfileType(val id: Int, @DrawableRes val drawableId: Int, @StringRes val nameId: Int) {

    // Note: The enum 'id' value is stored in application database
    // so care should be taken to keep the ids consistent when
    // adding or removing enums

    PROFILE_TYPE_WALKING(1000, R.drawable.ic_profile_walking_black_24dp, R.string.profile_name_walking),
    PROFILE_TYPE_RUNNING(1001, R.drawable.ic_profile_running_black_24dp, R.string.profile_name_running),
    PROFILE_TYPE_CYCLING(1002, R.drawable.ic_profile_cycling_black_24dp, R.string.profile_name_cycling),
    PROFILE_TYPE_DRIVING(1003, R.drawable.ic_profile_driving_black_24dp, R.string.profile_name_driving),
    PROFILE_TYPE_BOATING(1004, R.drawable.ic_profile_boating_black_24dp, R.string.profile_name_boating),
    PROFILE_TYPE_MOTORCYCLING(1005, R.drawable.ic_profile_motorcycling_black_24dp, R.string.profile_name_motorcycling);

    fun getName(context: Context): String {
        return context.getString(nameId)
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    companion object {

        @JvmStatic
        fun fromId(id: Int, defaultValue: ProfileType = PROFILE_TYPE_WALKING): ProfileType {
            return values().firstOrNull { it.id == id } ?: defaultValue
        }
    }
}