import java.io.FileOutputStream
import java.io.IOException

class FileControl : IExecutable() {
    override fun question_01() {
        try {
            val fs = FileOutputStream("output.txt")
            val outputString = "This is the string to write.\n"
            fs.write(outputString.toByteArray())
            fs.close()
            println("Completed.")
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun question_02() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun question_03() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun question_04() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}