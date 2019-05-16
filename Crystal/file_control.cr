require "./IExecutable"

class FileControl < IExecutable
    def question_1
        fs = File.open("output.txt", "w")
        output_string = "This is the string to write.\n"
        fs.puts(output_string)
        fs.close
        puts "Completed."
    end

    def question_2; end
    def question_3; end
    def question_4; end
end