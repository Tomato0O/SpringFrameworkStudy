import org.example.pojo.Student

beans {
    stu11(Student) {
        age = 20
        sex = '女'
        name = "李四"
    }

    stu22(Student.Boy) {
        height = 183
    }
}
