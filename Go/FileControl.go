package main

import (
	"fmt"
	"log"
)
import "io/ioutil"

type FileControl struct {}

func (fileControl FileControl) execute(num int) {
	switch num {
	case 1: fileControl.question1()
	case 2: fileControl.question2()
	case 3: fileControl.question3()
	case 4: fileControl.question4()
	}
}

func (fileControl FileControl) question1() {
	outputString := []byte("This is the string to write.\n")
	err := ioutil.WriteFile("output.txt", outputString, 0777)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Completed.")
}

func (fileControl FileControl) question2() {
	panic("implement me")
}

func (fileControl FileControl) question3() {
	panic("implement me")
}

func (fileControl FileControl) question4() {
	panic("implement me")
}


