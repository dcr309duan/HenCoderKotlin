package com.example.lesson.entity

/**
 * @author dcr
 * @date 2020/7/10  19:58
 */
internal class Lesson(var date: String?, var content: String?, var state: State?) {
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }
}