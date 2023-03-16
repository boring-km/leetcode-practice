package study

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var area = 0

    // 양 끝이 만날 때 까지 최댓값 계산
    while (left < right) {
        // 짧은 쪽으로 해야 전체를 사각형으로 감쌀 수 있음
        val mini = height[left].coerceAtMost(height[right])
        val nextArea = (right - left) * mini    // 가로 x 세로
        area = area.coerceAtLeast(nextArea)
        if (height[left] < height[right]) {
            left++  // 오른쪽이 높으면 왼쪽 당기기
        } else {
            right-- // 왼쪽이 높으면 오른쪽 당기기
        }
    }

    return area
}

fun main() {
    var result = maxArea(intArrayOf(1, 1))
    println(result)
    result = maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
    println(result)
}