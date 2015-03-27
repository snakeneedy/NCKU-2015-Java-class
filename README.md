NCKU-2015-Java-class
==========

HW_1
-----
給定兩個字串，先將個別字串首字元移到尾端，並加上"ay"，形成新字串；再將個別新字串首字大寫，才將兩字串以空格隔開成一個新字串。
> System.out.print 的使用，String 的串接，和如何使用 substring(), toUpperCase()

HW_2
-----
1. 給定一個文字檔，若內容行數為奇數，取代第一個"hate"為"love"；若為偶數，取代最後一行的"hate"為"love"。
2. 取代"JAVA"為"Java Software Development"，任意大小寫都要考慮，意即"jAva"和"JavA"都要取代。

> HW_1 的技能加上 String 的函數使用：indexOf( String ), lastIndexOf( String )

> 備註：**需要 catch FileNotFoundException**

HW_3 
----------
*deadline: 2015/04/10 Fri. 09:00*

作業說明

1. 給定一個由字母寫成的數學式，各字母分別代表某一個0~9的數字，且不重複；開頭的數字不為0
2. 如`SEND + MORE = MONEY`結果為`S=9, R=8, O=0, M=1, Y=2, E=5, N=6, D=7`
3. 輸出格式：`(c1, d1); (c2, d2); `(中間要有空格隔開)	

範例輸入檔`file.txt`

	QQ + OO = TOT
	TOO + TOO + TOO + TOO = GOOD
	TAKE + A + CAKE = KATE
	EAT + THAT = APPLE

範例輸出Console

	(O,2); (Q,9); (T,1);
	(D,6); (G,1); (O,9); (T,4);
	(A,9); (C,2); (E,1); (K,6); (T,3);
	(A,1); (E,8); (H,2); (L,3); (P,0); (T,9);
