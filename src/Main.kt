import kotlin.random.Random

// 컴파일 타임 상수
// main 보다 우선해서 컴파일, 성능상 이점이 있다고 함
const val score = 100

fun main() {
    print("hello world")
    println("hello world")

    // 변수, 대문자로 된 타입 선택
//    var i: Int = 10
    var name: String = "hello"
    var point: Double = 1.1
    var l = 20L  // long

//    i = l.toInt()

    // 상수
    val num = 20
    // num = 1 불가 java final 과 유사

    println(name.uppercase())
    println(name[1])

    println(name + " world!!")
    println("$name world!!")

//    var i = 10
    var j = 20

//    println(max(i, j))

    // random
    val randomNumber = Random.nextInt(0, 100)
    println(randomNumber)


    // 입력
//    val reader = Scanner(System.`in`)
//    reader.next()
//    reader.nextInt()

    // 조건문
    var i = 5

//    if (i > 10) {
//        println("10보다 크다")
//    } else if (i > 5) {
//        println("5보다 크다")
//    } else {
//        println("")
//    }
    // 상동
    when {
        i > 10 -> {
            println("10보다 크다")
        }
        i > 5 -> {
            println("5보다 크다")
        }
        else -> {
            println("!!!")
        }
    }

    val result = if (i > 10) {
        "10보다 크다"
    } else {
        "10보다 작다"
    }
    println(result)

    // 반복문
    val items = listOf(1,2,3,4,5)
    for (item in items) {
        println(item)
    }
    // 동일
//    items.forEach {item ->
//        println(item)
//    }

    for (i in 0..items.size - 1) {
        println(items[i])
    }

    val mutableItems = mutableListOf(1, 2, 3, 4, 5)
    mutableItems.add(6)
    mutableItems.add(3)

    // array, list를 보통 사용한다
    val arrays = arrayOf(1, 2, 3)
    arrays[0] = 10

    try {
        val item = arrays[5]
    } catch (e: Exception) {
        println(e.message)
    }

    // null safety
    var name1 : String? = null
    var name2 : String = ""
    // name1, name2 는 서로 다른 타입

    // name2 = name1!! !! 는 지양
    name1?.let {  // if (name1 != null)
        name2 = name1
    }

    // func
    print(sum(10, 20))

    // class
    val john = Person("John", 20)
    john.age = 21
    // john.name = "james"
    val john2 = Person("John", 20)

    println(john)
    println(john2)
    println(john == john2)  // equals, hashcode 없이 data class 사용하면 둘이 같다고 판단됨

    println(john.hobby)

    // type check is
    val dog: Animal = Dog()
    val dog2: Dog = Dog()
    if (dog is Dog) {
        println("멍멍이")
    }

    if (dog2 is Animal) {
        println("멍멍이2")
    }

    // generic
    val box = Box(10)
    val box2 = Box("asdf")
    println(box.value)


    // callback 고차함수
    myFunc { println("함수 호출") }


    // coroutine

}

fun sum (a: Int, b: Int ) : Int {
    return a + b
}

fun sum2 (a: Int, b: Int, c: Int = 0) = a + b + c


class Person(val name: String, var age: Int) {
    var hobby = "축구"
        private set
        get() = "취미: $field"
}
class Person2(private val name: String, private var age: Int)


interface Drawable {
    fun draw()
}

abstract class Animal {
    open fun move() {
        println("move")
    }
}

class Dog : Animal(), Drawable {
    override fun move() {
        println("dog move")
    }
    override fun draw() {
        println("dog draw")
    }
}

//class SuperMan: Person("John", 20)  // open class person, open 이어야 함

class Box<T>(var value: T)

fun myFunc(callBack: () -> Unit) {  // void 가 아니라 Unit
    println("함수 시작!")
    callBack()
    println("함수 끝!!!")
}