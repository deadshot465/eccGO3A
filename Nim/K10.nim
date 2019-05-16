import IExecutable

type K10* = ref object of IExecutable

method question1*(this: K10) =
    stdout.write "文字列の入力＞"
    stdout.flushFile
    var input_str = readLine(stdin)
    echo "入力された文字列の文字数：", input_str.len  

method question2*(this: K10) =
    var str = "STRINGcopy"
    echo "コピーしたい文字列：", str
    var copy_str = str
    echo "コピー後の文字列：", copy_str

method question3*(this: K10) =
    var str = [
        "abcdef", "GHIJKL", "13579"
    ]
    var str_combined = ""
    echo "連結したい３つの文字列："
    for s in str:
        echo s
        str_combined.add(s)
    echo "連結した文字列：", str_combined

method question4*(this: K10) =
    var alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var input_string = "I AM A STUDENT. I AM GOOD AT GAME PROGRAMMING."
    var count = 0
    var count2 = 0

    echo "文字列：", input_string
    echo "\n文字頻度"
    for s in alphabets:
        for s2 in input_string:
            if s == s2:
                count += 1
        stdout.write s, ": ", count, "\t"
        stdout.flushFile
        count = 0
        count2 += 1
        if count2 mod 4 == 0:
            echo ""