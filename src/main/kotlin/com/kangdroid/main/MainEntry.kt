package com.kangdroid.main

import com.kangdroid.main.args.ArgumentParser

/**
 * Client Main Entry
 */
fun main(args: Array<String>) {
    val argumentParser: ArgumentParser = ArgumentParser(args)
    argumentParser.parseMain()
}