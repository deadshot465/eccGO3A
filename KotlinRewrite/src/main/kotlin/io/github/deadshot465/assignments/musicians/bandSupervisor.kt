package io.github.deadshot465.assignments.musicians

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun startBand(maxRetries: Int) {
    val channel = Channel<Pair<String, SkillLevel>>(10)
    val members = mutableMapOf(
        "singer" to addBandMember("singer", SkillLevel.Good, channel),
        "bass" to addBandMember("bass", SkillLevel.Good, channel),
        "drum" to addBandMember("drum", SkillLevel.Bad, channel),
        "guitar" to addBandMember("guitar", SkillLevel.Good, channel)
    )

    var retries = maxRetries
    while (true) {
        val data = channel.receive()
        retries -= 1
        members.remove(data.first)

        if (retries <= 0) {
            println("The manager is mad and fired the whole band!")
            for (chan in members.values) {
                chan.send(0)
            }
            delay(3000)
            break
        }

        members[data.first] = addBandMember(data.first, data.second, channel)
    }
}

private fun addBandMember(role: String, skillLevel: SkillLevel, channel: Channel<Pair<String, SkillLevel>>): Channel<Int> {
    val fireChannel = Channel<Int>(10)
    val musician = Musician(role, skillLevel, fireChannel)
    CoroutineScope(Dispatchers.Default).launch {
        while (true) {
            delay(delay)
            val playResult = musician.playSound()
            if (playResult) {
                continue
            }

            channel.send(Pair(role, skillLevel))
            break
        }
    }

    return fireChannel
}