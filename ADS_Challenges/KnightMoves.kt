import java.util.*

fun main() {

    var dx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
    var dy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

    var a = Array(9) { IntArray(9) }
    val q: Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()

    val input = Scanner(System.`in`)

    val x1 = input.nextInt()
    val y1 = input.nextInt()
    val x2 = input.nextInt()
    val y2 = input.nextInt()
    
    q.add(Pair(x1,y1))

    while(q.isNotEmpty()){
        val x: Int = q.element().first
        val y: Int = q.element().second
        for (i in 0..7) {
            if (ok(x + dx[i], y + dy[i]) && a[x + dx[i]][y + dy[i]] == 0) {
                q.add(Pair(x + dx[i], y + dy[i]))
                a[x + dx[i]][y + dy[i]] = a[x][y] + 1
            }
        }
        q.poll()
    }
    
    println(a[x2][y2])
}

fun ok(x: Int, y: Int): Boolean {
    return x in 1..8 && y in 1..8
}
