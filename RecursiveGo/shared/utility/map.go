package utility

import "strconv"

func MapIntToString(arr []int) []string {
	var acc []string
	return innerMapIntToString(arr, acc)
}

func innerMapIntToString(arr []int, acc []string) []string {
	if len(arr) == 0 {
		return acc
	}
	return innerMapIntToString(arr[1:], append(acc, strconv.Itoa(arr[0])))
}