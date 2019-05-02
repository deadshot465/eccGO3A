pub trait Executable
{
    fn execute(&self, chapter: u32)
    {
        match chapter
            {
                1 => self.question_1(),
                2 => self.question_2(),
                3 => self.question_3(),
                4 => self.question_4(),
                _ => ()
            }
    }

    fn question_1(&self);
    fn question_2(&self);
    fn question_3(&self);
    fn question_4(&self);
}