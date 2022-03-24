class Question
    def question1; end
    def question2; end
    def question3; end
    def question4; end

    def execute(n : Int32)
        case n
        when 1
            question1()
        when 2
            question2()
        when 3
            question3()
        when 4
            question4()
        else
            return
        end
    end
end