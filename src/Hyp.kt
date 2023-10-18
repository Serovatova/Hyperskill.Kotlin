package src


const val regexMeters = "m(eter)?s?"
const val regexKilometers = "(?i)k(ilo)?m(eter)?s?"
const val regexCentimeters = "(?i)c(m|entimeter|entimeters)"
const val regexMillimeters = "(?i)m(ill)?i?m(eter)?s?"
const val regexMiles = "(?i)m(i|ile|iles)?"
const val regexYards = "(?i)y(ar)?d(s)?"
const val regexFeet = "(?i)f(oo|ee)?t"
const val regexInches = "in(ch|ches)?"

//-----------------------------------------------------------------------
const val regexGrams = "\\b(g(ram|rams)?)\\b"
const val regexKilograms = "\\b(kg|kilogram|kilograms)\\b"
const val regexMilligrams = "\\b(mg|milligram|milligrams)\\b"
const val regexPounds = "\\b(lb|pound|pounds)\\b"
const val regexOunce = "\\b(oz|ounce|ounces)\\b"

//----------------------------------------------------------------------------------------------------------------------
const val METER = "meter"
const val KILOMETER = "kilometer"
const val CENTIMETER = "centimeter"
const val MILLIMETER = "millimeter"
const val MILE = "mile"
const val YARD = "yard"
const val FOOT = "foot"
const val FEET = "feet"
const val INCHES = "inch"

//----------------------------------------------------------------------------------------------------------------------
const val GRAMS = "gram"
const val KILOGRAMS = "kilogram"
const val MILLIGRAMS = "milligram"
const val POUNDS = "pound"
const val OUNCES = "ounce"
fun main() {

    while (true) {
        println("Enter a number and a measure of length: ")

        val input = readln().trim().takeUnless { it == "exit" }?.split("\\s+".toRegex()) ?: break

        when (input.size) {
            2 -> {
                val (value, unit) = input
                checkRegexAndConvertInMetersOrGrams(value.toDouble(), unit)
            }

            3 -> {
                val (value, unit, to) = input
            }

            4 -> {
                val (value, unit, to, convert) = input
                val conv = checkRegexAndConvertInMetersOrGrams(value.toDouble(), unit)
                checkRegexAndConvertInUnit(conv as Double, convert)
            }
        }

    }

}

fun checkRegexAndConvertInUnit(value: Double, convert: String): Any {
    return when {
        Regex(regexMeters, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, METER, oneValue(value), metersToMeters(value), valueOnValue(value))
            return metersToMeters(value)
        }

        Regex(regexKilometers, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, KILOMETER, oneValue(value), metersToKilometers(value), valueOnValue(value))
            return metersToKilometers(value)
        }

        Regex(regexCentimeters, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, CENTIMETER, oneValue(value), metersToCentimeters(value), valueOnValue(value))
            return metersToCentimeters(value)
        }

        Regex(regexMillimeters, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, MILLIMETER, oneValue(value), metersToMillimeters(value), valueOnValue(value))
            return metersToMillimeters(value)
        }

        Regex(regexMiles, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, MILE, oneValue(value), metersToMiles(value), valueOnValue(value))
            return metersToMiles(value)
        }

        Regex(regexYards, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, YARD, oneValue(value), metersToYards(value), valueOnValue(value))
            return metersToYards(value)
        }

        Regex(regexFeet, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, FEET, oneValue(value), metersToFeet(value), valueOnValue(value))
            return metersToFeet(value)
        }

        Regex(regexInches, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoMeters(value, INCHES, oneValue(value), metersToInches(value), valueOnValue(value))
            return metersToInches(value)
        }
        //-------------------------------------------------------------
        Regex(regexGrams, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoGrams(value, GRAMS, oneValue(value), gramsToGrams(value))
            return gramsToGrams(value)
        }

        Regex(regexKilograms, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoGrams(value, KILOGRAMS, oneValue(value), gramsToKilograms(value))
            return gramsToKilograms(value)
        }

        Regex(regexMilligrams, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoGrams(value, MILLIGRAMS, oneValue(value), gramsToMilligrams(value))
            return gramsToMilligrams(value)
        }

        Regex(regexPounds, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoGrams(value, POUNDS, oneValue(value), gramsToPounds(value))
            return gramsToPounds(value)
        }

        Regex(regexOunce, RegexOption.IGNORE_CASE).matches(convert) -> {
            printConvertIntoGrams(value, OUNCES, oneValue(value), gramsToOunce(value))
            return gramsToOunce(value)
        }

        else -> {
            println("Wrong input. Unknown unit $convert")
        }
    }
}

fun checkRegexAndConvertInMetersOrGrams(value: Double, unit: String): Any {
    return when {
        Regex(regexMeters, RegexOption.IGNORE_CASE).matches(unit) -> {
            return metersToMeters(value)
        }

        Regex(regexKilometers, RegexOption.IGNORE_CASE).matches(unit) -> {
            return kilometersToMeters(value)
        }

        Regex(regexCentimeters, RegexOption.IGNORE_CASE).matches(unit) -> {
            return centimetersToMeters(value)
        }

        Regex(regexMillimeters, RegexOption.IGNORE_CASE).matches(unit) -> {
            return millimetersToMeters(value)
        }

        Regex(regexMiles, RegexOption.IGNORE_CASE).matches(unit) -> {
            return milesToMeters(value)
        }

        Regex(regexYards, RegexOption.IGNORE_CASE).matches(unit) -> {
            return yardsToMeters(value)
        }

        Regex(regexFeet, RegexOption.IGNORE_CASE).matches(unit) -> {
            return feetToMeters(value)
        }

        Regex(regexInches, RegexOption.IGNORE_CASE).matches(unit) -> {
            return inchesToMeters(value)
        }

        //-------------------------------------------------------------
        Regex(regexGrams, RegexOption.IGNORE_CASE).matches(unit) -> {
            return gramsToGrams(value)
        }

        Regex(regexKilograms, RegexOption.IGNORE_CASE).matches(unit) -> {
            return kilogramsToGrams(value)
        }

        Regex(regexMilligrams, RegexOption.IGNORE_CASE).matches(unit) -> {
            return gramsToMilligrams(value)
        }

        Regex(regexPounds, RegexOption.IGNORE_CASE).matches(unit) -> {
            return poundsToGrams(value)
        }

        Regex(regexOunce, RegexOption.IGNORE_CASE).matches(unit) -> {
            return ounceToGrams(value)
        }

        else -> {
            println("Wrong input. Unknown unit $unit")
        }
    }
}

fun oneValue(value: Double): String {
    return if (value == 1.0) "" else "s"
}

fun printConvertIntoGrams(value: Double, convertUnit: String, end: String, grams: Double) {
    println("$value $convertUnit$end is $grams grams")
}

fun printConvertIntoMeters(value: Double, convertUnit: String, end: String, meter: Double, endMeter: String) {
    println("$value $convertUnit$end is $meter meter$endMeter")
}

fun printFeet(value: Double, meters: Double) {
    if (value == 1.0) {
        println("$value foot is $meters meters")
    } else {
        println("$value feet is $meters meters")
    }
}

fun valueOnValue(value: Double): String {
    return if (value == 100.0 || value == 0.001 || value == 1000.0) "" else "s"
}

//----------------------------------------------------------------------------------------------------------------------
fun gramsToGrams(value: Double): Double {
    return value
}

fun kilogramsToGrams(value: Double): Double {
    return value * 1000
}

fun milligramsToGrams(value: Double): Double {
    return value * 0.001
}

fun poundsToGrams(value: Double): Double {
    return value * 453.592

}

fun ounceToGrams(value: Double): Double {
    return value * 28.3495
}
//----------------------------------------------------------------------------------------------------------------------

fun gramsToKilograms(value: Double): Double {
    return value / 1000
}

fun gramsToMilligrams(value: Double): Double {
    return value / 0.001
}

fun gramsToPounds(value: Double): Double {
    return value / 453.592
}

fun gramsToOunce(value: Double): Double {
    return value / 28.3495
}

//----------------------------------------------------------------------------------------------------------------------
fun metersToMeters(value: Double): Double {

    val endM = if (value == 100.0) "s" else ""

    return value
}

fun kilometersToMeters(value: Double): Double {
    return value * 1000
}

fun centimetersToMeters(value: Double): Double {
    return value * 0.01

}

fun millimetersToMeters(value: Double): Double {
    return value * 0.001

}

fun milesToMeters(value: Double): Double {
    return value * 1609.35
}

fun yardsToMeters(value: Double): Double {
    return value * 0.9144
}

fun feetToMeters(value: Double): Double {
    return value * 0.3048
}

fun inchesToMeters(value: Double): Double {
    return value * 0.0254
}

//-----------------------------------------------------------------

fun metersToKilometers(value: Double): Double {
    return value / 1000
}

fun metersToCentimeters(value: Double): Double {
    return value / 0.01

}

fun metersToMillimeters(value: Double): Double {
    return value / 0.001

}

fun metersToMiles(value: Double): Double {
    return value / 1609.35
}

fun metersToYards(value: Double): Double {
    return value / 0.9144
}

fun metersToFeet(value: Double): Double {
    return value / 0.3048
}

fun metersToInches(value: Double): Double {
    return value / 0.0254
}
