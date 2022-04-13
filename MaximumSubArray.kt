/**
 * Array Data Structure Problem
 * Largest Sum Contiguous Sub-array
 * Kotlin solution :
 * 1- Simple approach = time complexity O(n*n) where n is size of array
 * 2- kadane approach = time complexity O(n) where n is size of array
 */
class MaximumSubArray {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val array = arrayOf(1, 3, 8, -2, 6, -8, 5)
            val simpleApproach = simpleApproach(array)
            val kadaneSolution = kadaneSolution(array)
            print("Maximum Sub array : simpleSolution $simpleApproach  kadaneSolution $kadaneSolution")

        }

        private fun simpleApproach(array: Array<Int>): Int {
            var maximumSubArray = Int.MIN_VALUE
            for (i in array.indices) {
                var curSum = 0
                for (j in i until array.size) {
                    curSum += array[j]
                    if (curSum > maximumSubArray) {
                        maximumSubArray = curSum
                    }
                }// end of j
            }// end of i
            return maximumSubArray
        }

        private fun kadaneSolution(array: Array<Int>): Int {
            var maximumSubArray = Int.MIN_VALUE
            var currentSum = 0
            for (i in array.indices) {
                currentSum += array[i]
                if (currentSum > maximumSubArray) {
                    maximumSubArray = currentSum
                }
                if (currentSum < 0) {
                    currentSum = 0
                }
            }
            return maximumSubArray
        }
    }
}
