pub fn rpn(input: &str) -> Result<f32, String> {
    let mut numbers = input.split(" ").fold(vec![], inner_rpn);
    let result = numbers.pop().unwrap_or_default();
    if !numbers.is_empty() {
        Err("Bad input.".into())
    } else {
        Ok(result)
    }
}

fn inner_rpn(mut numbers: Vec<f32>, op: &str) -> Vec<f32> {
    match op {
        "+" | "-" | "*" | "/" | "^" => {
            let n1 = numbers.pop().unwrap_or_default();
            let n2 = numbers.pop().unwrap_or_default();
            match op {
                "+" => numbers.push(n2 + n1),
                "-" => numbers.push(n2 - n1),
                "*" => numbers.push(n2 * n1),
                "/" => numbers.push(n2 / n1),
                "^" => numbers.push(n2.powf(n1)),
                _ => (),
            }
            numbers
        }
        "ln" => {
            let n1 = numbers.pop().unwrap_or_default();
            numbers.push(n1.ln());
            numbers
        }
        "log10" => {
            let n1 = numbers.pop().unwrap_or_default();
            numbers.push(n1.log10());
            numbers
        }
        "sum" => {
            vec![numbers.into_iter().sum()]
        }
        "prod" => {
            vec![numbers.into_iter().product()]
        }
        _ => {
            numbers.push(op.parse::<f32>().unwrap_or_default());
            numbers
        }
    }
}

#[cfg(test)]
pub mod tests {
    use crate::questions::extra::rpn::rpn;

    #[test]
    pub fn test_plus() {
        assert_eq!(Ok(5.0), rpn("2 3 +"));
    }

    #[test]
    pub fn test_minus() {
        assert_eq!(Ok(87.0), rpn("90 3 -"));
    }

    #[test]
    pub fn test_multiply() {
        assert_eq!(Ok(-4.0), rpn("10 4 3 + 2 * -"));
    }

    #[test]
    pub fn test_divide() {
        assert_eq!(Ok(-2.0), rpn("10 4 3 + 2 * - 2 /"));
    }

    #[test]
    pub fn test_bad_input() {
        assert_eq!(
            Err("Bad input.".to_string()),
            rpn("90 34 12 33 55 66 + * - +")
        );
    }

    #[test]
    pub fn test_complex_input() {
        assert_eq!(Ok(4037.0), rpn("90 34 12 33 55 66 + * - + -"));
    }

    #[test]
    pub fn test_power() {
        assert_eq!(Ok(8.0), rpn("2 3 ^"));
    }

    #[test]
    pub fn test_sqrt() {
        assert_eq!(Ok(2.0_f32.sqrt()), rpn("2 0.5 ^"));
    }

    #[test]
    pub fn test_ln() {
        assert_eq!(Ok(2.7_f32.ln()), rpn("2.7 ln"));
    }

    #[test]
    pub fn test_log10() {
        assert_eq!(Ok(2.7_f32.log10()), rpn("2.7 log10"));
    }

    #[test]
    pub fn test_sum() {
        assert_eq!(Ok(50.0), rpn("10 10 10 20 sum"));
    }

    #[test]
    pub fn test_sum_and_divide() {
        assert_eq!(Ok(10.0), rpn("10 10 10 20 sum 5 /"));
    }

    #[test]
    pub fn test_product() {
        assert_eq!(Ok(1000.0), rpn("10 10 20 0.5 prod"));
    }
}
