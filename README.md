# NCKU-2015-Java-class

## HW_1

給定兩個字串，先將個別字串首字元移到尾端，並加上"ay"，形成新字串；再將個別新字串首字大寫，才將兩字串以空格隔開成一個新字串。
> System.out.print 的使用，String 的串接，和如何使用 substring(), toUpperCase()

## HW_2

1. 給定一個文字檔，若內容行數為奇數，取代第一個"hate"為"love"；若為偶數，取代最後一行的"hate"為"love"。
2. 取代"JAVA"為"Java Software Development"，任意大小寫都要考慮，意即"jAva"和"JavA"都要取代。

> HW_1 的技能加上 String 的函數使用：indexOf( String ), lastIndexOf( String )

> 備註：**需要 catch FileNotFoundException**

## HW_3 

*deadline: 2015/04/10 Fri. 09:00*

**作業說明**

1. 給定一個由字母寫成的數學式，各字母分別代表某一個0~9的數字，且不重複；開頭的數字不為0
2. 如`SEND + MORE = MONEY`結果為`S=9, R=8, O=0, M=1, Y=2, E=5, N=6, D=7`
3. 輸出格式：`(c1, d1); (c2, d2); `(中間要有空格隔開)	

**範例輸入檔`file.txt`**

	QQ + OO = TOT
	TOO + TOO + TOO + TOO = GOOD
	TAKE + A + CAKE = KATE
	EAT + THAT = APPLE

**範例輸出Console**

	(O,2); (Q,9); (T,1);
	(D,6); (G,1); (O,9); (T,4);
	(A,9); (C,2); (E,1); (K,6); (T,3);
	(A,1); (E,8); (H,2); (L,3); (P,0); (T,9);

## HW_4

*deadline: 2015/04/17 Fir. 09:00*

**作業說明：**

透過`command`輸入存至`String args[]`，讀取多個`csv`檔，檔案內容由`,`(逗號)分隔。第一行表示商品名稱，接下來的幾行表示使用者對商品的評價，以1~5為評分，求出各商品的(1)平均評分、(2)最大評分、(3)最小評分、(4)標準差，並將結果由`平均評分`遞減排序，格式如範例結果。

**範例檔案：`hw4_file1.csv`、`hw4_file1.csv`**

hw4_file1.csv

	Caffé Latte,Java Chip Frappuccino,Espresso,Cappuccino
	2,5,1,3
	3,5,,4
	4,5,2,1

hw4_file2.csv

	Signature Hot Chocolate,Caramel Frappuccino,Ristretto Bianco
	1,2,3
	3,5,5
	4,3,1
	2,4,2

**範例執行：**

```bash
javac HW_4.java
java HW_4 hw4_file1.csv hw4_file2.csv
```

範例結果：

	--001--
	[Java Chip Frappuccino,   5.00, 5, 5, 0.00]
	[Caffé Latte,             3.00, 4, 2, 1.00]
	[Cappuccino,              2.67, 4, 1, 1.53]
	[Espresso,                1.50, 2, 1, 0.71]
	--002--
	[Caramel Frappuccino,     3.50, 5, 2, 1.29]
	[Ristretto Bianco,        2.75, 5, 1, 1.71]
	[Signature Hot Chocolate, 2.50, 4, 1, 1.29]

## HW_5

*deadline: 2015/05/01 Fir. 09:00*

**作業說明：**

1. 找到組成某字串的子字串，其中字母可以不用照順序。如字串 swimming 之子字串可為 swim, win, sing, miming, etc.。
2. 寫出程式能在給予的字典檔`dictionary.txt`中，找出符合`hw5_input.txt`中字串的子字串。
3. `dictionary.txt`和`hw5_input.txt`分別由 argument 讀入 args[0], args[1]

**​輸出說明：**

$$Word_{G} => Word_{1}, Word_{2}, ..., Word_{n},$$

其中 $Word_{G}$ 包含在`hw5_input.txt`，$Word_{i}$ 包含在`dictionary.txt`。

**Hint in pdf**

1. Create an array that counts up the number of each letter in the given word (e.g., one S, one W, two I, two W, etc.)
2. And then creates a similar array for the current word read from `dictionary.txt`.
3. The two arrays can be compared to see if the word from `dictionary.txt` could created out of the letters from the given word.

**輸入範例：**

- [hw5_input.txt](HW_5/hw5_input.txt)
- [dictionary.txt](HW_5/dictionary.txt)

**輸出範例：**

	asus => ass, usa, 
	htc => 
	sony => nos, nosy, son, soy, yon, 
	yahoo => ahoy, hay, oho, ooh, yahoo, 
	nike => ink, ken, kin, kine, 
	puma => amp, amu, map, puma, ump, 
	casio => cia, ciao, sac, sci, sic, soc, 
	benq => ben, neb, 
	canon => ann, anno, anon, can, canon, con, conn, nan, non, 
	nikon => ikon, ink, inn, ion, kin, non, oink, 

## HW_6

*deadline: 2015/05/15 Fir. 09:00*

**作業說明：**

- 由 command 的方式將`hw6_input.txt`讀入，針對每一行的**中序**運算式，先**轉成前序**，再求出其算式結果。
- 運算元只會是整數，運算子有`+`、`-`、`*`、`/`、`(`、`)`，其中除法不考慮浮點數，用`int`運算即可
- 需判斷是否有不合法的輸入、`int`的溢位、除於 0 的問題

**範例輸入：**

	1 + 2
	6 + 5 * 4
	1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10
	999 - 888 * ( 777 / 666 ) - 555 + 444
	-6 + 0 - ( -6 )
	( ( 1 + 2 ) + 3 ) + 4 + 5 )
	5 / 0 + 1
	2147483647 + 1
	1234567890
	9876543210

**範例輸出：**

	1 2 +
	3
	6 5 4 * +
	26
	1 2 - 3 + 4 - 5 + 6 - 7 + 8 - 9 + 10 -
	-5
	999 888 777 666 / * - 555 - 444 +
	0
	-6 0 + -6 -
	0
	Invalid expression
	Invalid expression
	5 0 / 1 +
	Divide by zero
	2147483647 1 +
	Overflow
	1234567890
	1234567890
	9876543210
	Overflow

**參考演算法 pseudo code**

```java
transform (infix_expr) {
	for each (token) in (infix_expr)
		switch (token)
			case operand:
				if (pre_token is operand)
					return "Invalid expression"
				pre_token <- operand
				print (token)

			case operator:
				if (pre_token is operator)
					return "Invalid expression"
				pre_token <- operator
				while ( !stack.isEmpty()
						&& precedence(stack.top()) <= precedence(token) )
					print( stack.pop() )
				// precedence: [+-] < [*/] < [(]
				stack.push( token )

			case left-parentheses:
				if (pre_token is operand)
					return "Invalid expression"
				stack.push( token )

			case right-parentheses:
				if (pre_token is operator)
					return "Invalid expression"
				while (!stack.isEmpty() && stack.top() != left-parentheses)
					print( stack.pop() )
				if ( stack.isEmpty() )
					return "Invalid expression"
				stack.pop()
		end switch
	end for
	while( !stack.isEmpty() )
		print( stack.pop() )
}
```

```java
evaluate (postfix_expr) {
	for each (token) in (postfix_expr)
		switch (token)
			case operand:
				stack.push( token )
			case operator:
				Y <- stack.pop()
				X <- stack.pop()
				Temp <- X (token) Y
				// check if the value is overflow
				stack.push( Temp )
		end switch
	end for
	print( stack.top() )
}
```
