abstract class IExecutable : IDispatchable
{
    fun execute(num: Int)
    {
        when (num)
        {
            1 -> question_01()
            2 -> question_02()
            3 -> question_03()
            4 -> question_04()
        }
    }

}