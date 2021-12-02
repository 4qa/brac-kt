package net.javaman.brackt.api.util.logging

import net.javaman.brackt.api.BracKtApi
import net.javaman.brackt.api.util.injections.injection
import org.junit.jupiter.api.Test

class LoggerTest {
    private val logger: Logger by injection()

    init {
        BracKtApi.addInjections()
    }

    @Test
    fun loggerInjection_ok() {
        logger.info {
            "If you can see this, all is well! " +
                    "Otherwise, a ${NullPointerException::class.simpleName} should have been thrown"
        }
    }
}
