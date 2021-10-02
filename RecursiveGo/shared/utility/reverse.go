package utility

func ReverseInt(arr []int) []int {
	var acc []int
	return innerReverseInt(arr, acc)
}

func ReverseIntSlice(arr [][]int) [][]int {
	var acc [][]int
	return innerReverseIntSlice(arr, acc)
}

func ReverseString(arr []string) []string {
	var acc []string
	return innerReverseString(arr, acc)
}

func innerReverseInt(arr []int, acc []int) []int {
	if len(arr) == 0 {
		return acc
	}
	return innerReverseInt(arr[:len(arr) - 1], append(acc, arr[len(arr) - 1]))
}

func innerReverseIntSlice(arr [][]int, acc [][]int) [][]int {
	if len(arr) == 0 {
		return acc
	}
	return innerReverseIntSlice(arr[:len(arr) - 1], append(acc, arr[len(arr) - 1]))
}

func innerReverseString(arr []string, acc []string) []string {
	if len(arr) == 0 {
		return acc
	}
	return innerReverseString(arr[:len(arr) - 1], append(acc, arr[len(arr) - 1]))
}