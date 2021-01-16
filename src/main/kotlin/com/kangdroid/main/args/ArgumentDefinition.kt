package com.kangdroid.main.args

class ArgumentDefinition {

    // Automatically run server when it is not running at the moment.
    // --run-server
    var runServer: Boolean = false

    // Recursive delete?
    // -r || --recursive
    var isRecursive: Boolean = false

    // Force Delete?
    // -f || --force
    var isForce: Boolean = false

    companion object {
        @Volatile private var thisInstance: ArgumentDefinition? = null

        @JvmStatic fun getInstance(): ArgumentDefinition {
            return thisInstance ?: synchronized(this) {
                thisInstance ?: ArgumentDefinition().also {
                    thisInstance = it
                }
            }
        }
    }
}
