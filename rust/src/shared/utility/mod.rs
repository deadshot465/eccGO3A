use std::fmt::Debug;
use std::str::FromStr;

pub fn read_user_input<F>() -> anyhow::Result<F>
where
    F: FromStr,
    F::Err: Debug + Send + Sync + std::error::Error + 'static,
{
    let mut input = String::new();
    let result = std::io::stdin().read_line(&mut input);
    match result {
        Ok(_) => Ok(input.trim().parse::<F>()?),
        Err(e) => Err(anyhow::anyhow!("{}", e)),
    }
}
