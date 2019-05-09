package main

func getMaxValue(v1 int, v2 int, v3 int) int {
	var temp int
	if v1 >= v2 {
		temp = v1
	} else {
		temp = v2
	}

	if temp < v3 {
		temp = v3
	}
	return temp
}

func getMinValue(v1 int, v2 int, v3 int) int {
	var temp int
	if v1 < v2 {
		temp = v1
	} else {
		temp = v2
	}

	if temp >= v3 {
		temp = v3
	}

	return temp
}
