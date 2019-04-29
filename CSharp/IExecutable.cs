namespace CSharp
{
    public abstract class IExecutable : IDispatchable
    {
        public virtual void Execute(int num)
        {
            switch (num)
            {
                case 1:
                    Question01();
                    break;
                case 2:
                    Question02();
                    break;
                case 3:
                    Question03();
                    break;
                case 4:
                    Question04();
                    break;
                default:
                    break;
            }
        }

        public abstract void Question01();
        public abstract void Question02();
        public abstract void Question03();
        public abstract void Question04();
    }
}
