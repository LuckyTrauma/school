// ConsoleApplication28.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>

int main()
{
	FILE *g,*h;
	int c;
	g = fopen("poviedka.html", "r");
	h = fopen("poviedka_ale_lepsia.html", "w");
	while ((c = getc(g)) != EOF)
	{
		if (c == 165)
			c = 188;
		if (c == 169)
			c = 138;
		if (c == 171)
			c = 141;
		if (c == 174)
			c = 142;
		if (c == 181)
			c = 190;
		if (c == 185)
			c = 154;
		if (c == 187)
			c = 157;
		if (c == 190)
			c = 158;
		fputc(c, h);
		
	}
	fclose(g);
	fclose(h);

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
