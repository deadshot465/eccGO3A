abstract class IExecutable
    def execute(num : Int32)
        case num
        when 1
            question_1()
        when 2
            question_2()
        when 3
            question_3()
        when 4
            question_4()
        else
        end
    end

    abstract def question_1
    abstract def question_2
    abstract def question_3
    abstract def question_4
end