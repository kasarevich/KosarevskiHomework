package by.it_academy

class Student { // меняем класс на object - singleton
    var name: String = ""
    var surname: String = ""
    var age: Int
    get(){
        return 100
    }
    set(value){
        age = value
    }
}