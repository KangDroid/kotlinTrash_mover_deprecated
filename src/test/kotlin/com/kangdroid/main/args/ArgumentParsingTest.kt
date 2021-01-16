package com.kangdroid.main.args

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * TODO: Use @Before for cleanup?
 */
class ArgumentParsingTest {

    fun cleanup(argumentParser: ArgumentParser) {
        argumentParser.argsDefinition.isForce = false
        argumentParser.argsDefinition.isRecursive = false
        argumentParser.argsDefinition.runServer = false
    }

    @Test
    fun testArgumentParsingShortSingle() {
        // Let
        val args: Array<String> = arrayOf("-r")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // Check

        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingShortSingleFalse() {
        // Let
        val args: Array<String> = arrayOf("-a") // false one
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // Check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingShortMulti() {
        // Let
        val args: Array<String> = arrayOf("-rf")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumetParsingShortArray() {
        // Let
        val args: Array<String> = arrayOf("-r", "-f")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingShortMultiFalse() {
        // Let
        val args: Array<String> = arrayOf("-asd")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingLong() {
        // Let
        val args: Array<String> = arrayOf("--run-server")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(true)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingLongFalse() {
        // Let
        val args: Array<String> = arrayOf("--unknown-option")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(false)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(false)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingLongArray() {
        // Let
        val args: Array<String> = arrayOf("--run-server", "--recursive", "--force")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(true)

        // cleanup
        cleanup(argumentParser)
    }

    @Test
    fun argumentParsingCombined() {
        // Let
        val args: Array<String> = arrayOf("-r", "-f", "--run-server")
        val argumentParser: ArgumentParser = ArgumentParser(args)

        // do work.
        argumentParser.parseMain()

        // check
        assertThat(argumentParser.argsDefinition.isRecursive).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.isForce).isEqualTo(true)
        assertThat(argumentParser.argsDefinition.runServer).isEqualTo(true)

        // cleanup
        cleanup(argumentParser)
    }
}