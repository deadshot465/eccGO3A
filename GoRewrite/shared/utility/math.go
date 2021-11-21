package utility

func FindMaxValue(arr []int) int {
	max := arr[0]
	for _, i := range arr {
		if i > max {
			max = i
		}
	}
	return max
}

func FindMinValue(arr []int) int {
	min := arr[0]
	for _, i := range arr {
		if i < min {
			min = i
		}
	}
	return min
}