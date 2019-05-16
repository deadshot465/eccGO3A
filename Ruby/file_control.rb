class FileControl < Executable
  def question1
    begin
      fs = File.open('output.txt', 'w')
      output_string = 'This is the string to write.\n'
      fs.write(output_string)
      fs.close
      puts 'Completed.'
    rescue IOError => e
      puts e
    end
  end
end