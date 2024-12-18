package com.example.alarmclockapp.domain

data class AlarmClockItem(
    val alarmId: Int = 0,
    var description: String?,
    var isEnabled: Boolean,
    var minutesFromStartOfDay: Int,
    var vibration: Boolean,
    var dayOfTheWeek: Set<DayOfWeek>
)

enum class DayOfWeek{
    MONDAY {
        override fun toString(): String {
            return "monday"
        }
    },
    TUESDAY {
        override fun toString(): String {
            return "tuesday"
        }
    },
    WEDNESDAY {
        override fun toString(): String {
            return "wednesday"
        }
    },
    THURSDAY {
        override fun toString(): String {
            return "thursday"
        }
    },
    FRIDAY {
        override fun toString(): String {
            return "friday"
        }
    },
    SATURDAY {
        override fun toString(): String {
            return "saturday"
        }
    },
    SUNDAY {
        override fun toString(): String {
            return "sunday"
        }
    }
}