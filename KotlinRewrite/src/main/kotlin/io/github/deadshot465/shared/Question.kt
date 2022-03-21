package io.github.deadshot465.shared

interface Question {
    fun question1()
    fun question2()
    fun question3()
    fun question4()

    fun execute(num: Int) {
        when (num) {
            1 -> question1()
            2 -> question2()
            3 -> question3()
            4 -> question4()
            else -> {}
        }
    }
}