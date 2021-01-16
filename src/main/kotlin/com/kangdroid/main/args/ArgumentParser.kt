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

    // Long argument data
    private val longMap: HashMap<String, () -> Unit> = hashMapOf(
        "run-server" to {argsDefinition.runServer = true},
        "recursive" to {argsDefinition.isRecursive = true},
        "force" to {argsDefinition.isForce = true}
    )

    fun parseMain() {
        for (eachArgs in originalArgs) {
            if (eachArgs.get(0) == '-' && (eachArgs.get(1) != '-')) {
                parseShort(eachArgs.substring(1, eachArgs.length))
            } else if (eachArgs.get(0) == '-' && eachArgs.get(1) == '-') {
                parseLong(eachArgs.substring(2, eachArgs.length))
            }
        }
    }

    /**
     * Parse short ones.
     * Input should remove its '-'.
     */
    private fun parseShort(inputString: String) {
        for (singleChar in inputString) {
            val functionInvoke: () -> Unit = shortMap[singleChar] ?: {
                println("The argument $singleChar is not found.")
            }
            functionInvoke()
        }
    }

    /**
     * Parse Long ones.
     * Input should remove its '--'
     */
    private fun parseLong(inputString: String) {
        val functionInvoke: () -> Unit = longMap[inputString] ?: {
            println("The argument $inputString is not found.")
        }
        functionInvoke()
    }
}