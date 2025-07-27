package net.micg.habitmaster.feature.habits.presenter.models

data class HabitUi(
    val id: Int,
    val name: String,
    val isDoneToday: Boolean,
    val streak: Int,
    val likes: Int,
    val comments: Int,
    val daysUntilNextMark: Int,
) {
    val isRequiredToday get() = daysUntilNextMark <= 0
}
