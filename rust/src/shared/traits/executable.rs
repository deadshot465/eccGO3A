pub trait Executable {
    fn execute(&self, chapter: u32) -> anyhow::Result<()> {
        match chapter {
            1 => self.question_1(),
            2 => self.question_2(),
            3 => self.question_3(),
            4 => self.question_4(),
            _ => Ok(()),
        }
    }

    fn question_1(&self) -> anyhow::Result<()>;
    fn question_2(&self) -> anyhow::Result<()>;
    fn question_3(&self) -> anyhow::Result<()>;
    fn question_4(&self) -> anyhow::Result<()>;
}
