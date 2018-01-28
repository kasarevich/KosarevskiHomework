package by.it_academy

fun main(arg: Array<String>){

    var student = Student()
    student.name = "af"
    student.surname = "aetefsd"
    student.age = 25

    var list: MutableList<String>                   //val - constant


    val i = 50
    when(i){                // switch-case
       in 10..40 -> {       //  в диапазоне

        }
        50 ->{

        }
        else ->{

        }
    }


    for(a in arg){

    }

    var u: Int? = null   // ? - переменная может принимать значение null
    u?.compareTo(2.5)        //  u? = if(u != null) {...}  u!! - плевать на NullPointerException

    var c : Byte = u?.toByte() ?: 25 // - аналог сокращенного if-else

}

fun test(value: Int){ // все значения, входящие в метод - val

    var sd = value

    println("aefaef" + value)
}