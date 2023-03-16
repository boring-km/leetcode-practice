package study

import java.util.Stack

fun isValid(s: String): Boolean {
    val arr = s.toCharArray()

    val stack = Stack<Char>()

    for (ch in arr) {

        if (ch == '(') {
            stack.add(ch)
        } else if (ch == '{') {
            stack.add(ch)
        } else if (ch == '[') {
            stack.add(ch)
        } else if (ch == ')') {
            if (stack.isEmpty() || stack.pop() != '(') {
                return false
            }
        } else if (ch == '}') {
            if (stack.isEmpty() || stack.pop() != '{') {
                return false
            }
        } else if (ch == ']') {
            if (stack.isEmpty() || stack.pop() != '[') {
                return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()[]{}"))
    println(isValid("([{}])"))
    println(isValid("([)]"))
    println(isValid("(([]){})"))
}