package com.kangdroid.main.args

class ArgumentParser(input: Array<String>) {
    // Argument from main function
    val originalArgs: Array<String> = input

    // Argument Definition Store[The boolean data]
    var argsDefinition: ArgumentDefinition = ArgumentDefinition.getInstance()

    // Short argument data
    private val shortMap: HashMap<Char, () -> Unit> = hashMapOf(
        'r' to {argsDefinition.isRecursive = true},
        'f' to {argsDefinition.isForce = true}
    )

    fun parseMain() {
        for (eachArgs in originalArgs) {
            if (eachArgs.get(0) == '-' && (eachArgs.get(1) != '-')) {
                parseShort(eachArgs.substring(1, eachArgs.length))
            }
        }
    }

    /**
     * Parse short ones.
     * Input should remove its '-'.
     */
    private fun parseShort(inputString: String) {
        for (singleChar in inputString) {
            shortMap[singleChar]?.invoke()
        }
    }
}