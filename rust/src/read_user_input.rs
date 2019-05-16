use std::num::ParseIntError;

pub fn read_user_input(input_param: &mut String) -> Result<i32, ParseIntError> {
    std::io::stdin().read_line(input_param).unwrap_or_else(|err| {
        panic!(format!("入力失敗しました。エラー：{}", err.to_string()));
    });

    let result = input_param.trim().parse::<i32>()?;
    Ok(result)
}