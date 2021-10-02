package utility

func ReduceInt(arr []int) int {
	return innerReduceInt(arr, 0)
}

func innerReduceInt(arr []int, initialValue int) int {
	if len(arr) == 0 {
		return initialValue
	}
	return innerReduceInt(arr[1:], initialValue + arr[0])
}