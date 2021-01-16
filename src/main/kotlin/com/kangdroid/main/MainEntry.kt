package com.kangdroid.main

import com.kangdroid.main.args.ArgumentParser
import com.kangdroid.main.server.ServerChecker

/**
 * Client Main Entry
 */
fun main(args: Array<String>) {
    val argumentParser: ArgumentParser = ArgumentParser(args)
    argumentParser.parseMain()
}