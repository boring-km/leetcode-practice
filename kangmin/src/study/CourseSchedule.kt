package study


// https://velog.io/@ynoolee/LeetCode-207.Course-Schedule
object CourseSchedule {
    // 인접 리스트 그래프
    private var graph: Array<ArrayList<Int>> = Array(100001) { ArrayList<Int>() }

    // 방문 여부
    private lateinit var visit: BooleanArray

    // 함수 호출 종료 여부
    private lateinit var finish: BooleanArray

    // 싸이클 존재여부
    private var cycle = false
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // init table
        visit = BooleanArray(numCourses)
        finish = BooleanArray(numCourses)
        //===== init graph ====
        for (i in 0 until numCourses) graph[i] = ArrayList()
        // prerequisites[i][0] 의 부모노드 prerequisites[i][1]
        for (c in prerequisites) {
            graph[c[0]].add(c[1])
        }

        // 일단 모든 노드를 시작으로 한다
        for (i in 0 until numCourses) {
            dfs(i)
            if (cycle) break
        }
        // cycle이 존재함 -> 끝낼 수 없음
        // cycle이 존재하지 않음 -> 끝낼 수 있음
        return !cycle
    }

    // cur 노드를 방문
    private fun dfs(cur: Int) {
        if (visit[cur]) {
            // 이미 이 cur을 다녀간 dfs 함수가 아직 진행중 ( 인데 또 방문했다는 것은 cycle이 존재함을 뜻함)
            if (!finish[cur]) cycle = true
            // 중복 방문은 안되니까 (기하급수적으로 늘어나버림 )
            return
        }
        visit[cur] = true
        // 인접 노드들을 방문
        for (adj in graph[cur]) {
            dfs(adj)
        }
        finish[cur] = true
    }
}

fun main() {
//    println(CourseSchedule.canFinish(2, arrayOf(intArrayOf(1, 0))))
//    println(CourseSchedule.canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    println(CourseSchedule.canFinish(3, arrayOf(intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(2, 0))))
//    println(CourseSchedule.canFinish(5, arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 1), intArrayOf(3, 2))))
}