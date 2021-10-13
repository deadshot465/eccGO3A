use std::cmp::min;
use std::collections::VecDeque;
use std::num::ParseIntError;

#[derive(Clone, Debug, Ord, PartialOrd, Eq, PartialEq)]
struct Route {
    pub destination: i32,
    pub path: Vec<(char, i32)>,
}

#[derive(Clone, Debug)]
struct RoutingResult {
    pub a: Route,
    pub b: Route,
}

impl Default for Route {
    fn default() -> Self {
        Route {
            destination: 0,
            path: vec![],
        }
    }
}

pub fn run() -> Result<Vec<(char, i32)>, ParseIntError> {
    let content = std::fs::read_to_string("road.txt").unwrap_or_default();
    parse_map(content)
        .map(|v| group_values(v))
        .map(|v| optimal_path(v))
}

fn parse_map(content: String) -> Result<VecDeque<i32>, ParseIntError> {
    content
        .split_whitespace()
        .map(|s| s.trim())
        .filter(|s| !s.is_empty() && s.chars().count() > 0)
        .map(|s| s.parse::<i32>())
        .collect::<Result<VecDeque<_>, _>>()
}

fn group_values(mut numbers: VecDeque<i32>) -> VecDeque<(i32, i32, i32)> {
    let mut result = VecDeque::new();
    loop {
        let a = numbers.pop_front().unwrap_or_default();
        let b = numbers.pop_front().unwrap_or_default();
        let x = numbers.pop_front().unwrap_or_default();
        result.push_back((a, b, x));
        if numbers.is_empty() {
            break;
        }
    }
    result
}

fn shortest_steps(mut acc: RoutingResult, elem: (i32, i32, i32)) -> RoutingResult {
    let (a, b, x) = elem;

    let mut path_a1 = acc.a.path.clone();
    path_a1.push(('a', a));
    let opt_a1 = Route {
        destination: acc.a.destination + a,
        path: path_a1,
    };

    let mut path_a2 = acc.b.path.clone();
    path_a2.push(('b', b));
    path_a2.push(('x', x));
    let opt_a2 = Route {
        destination: acc.b.destination + b + x,
        path: path_a2,
    };

    let mut path_b1 = acc.b.path.clone();
    path_b1.push(('b', b));
    let opt_b1 = Route {
        destination: acc.b.destination + b,
        path: path_b1,
    };

    let mut path_b2 = acc.a.path.clone();
    path_b2.push(('a', a));
    path_b2.push(('x', x));
    let opt_b2 = Route {
        destination: acc.b.destination + a + x,
        path: path_b2,
    };

    RoutingResult {
        a: min(opt_a1, opt_a2),
        b: min(opt_b1, opt_b2),
    }
}

fn optimal_path(values: VecDeque<(i32, i32, i32)>) -> Vec<(char, i32)> {
    let RoutingResult { a, b } = values.into_iter().fold(
        RoutingResult {
            a: Route {
                destination: 0,
                path: vec![],
            },
            b: Route {
                destination: 0,
                path: vec![],
            },
        },
        shortest_steps,
    );

    let Route { path, .. } = if let Some(lst) = a.path.last().cloned() {
        if lst != ('x', 0) {
            a
        } else if let Some(lst) = b.path.last().cloned() {
            if lst != ('x', 0) {
                b
            } else {
                Route::default()
            }
        } else {
            Route::default()
        }
    } else {
        Route::default()
    };
    path
}

#[cfg(test)]
mod tests {
    use crate::questions::extra::road::run;

    #[test]
    pub fn test_heathrow_to_london() {
        let expected_road = vec![
            ('b', 10),
            ('x', 30),
            ('a', 5),
            ('x', 20),
            ('b', 2),
            ('b', 8),
        ];
        assert_eq!(Ok(expected_road), run())
    }
}
