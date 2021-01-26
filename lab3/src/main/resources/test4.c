#include <stdio.h>

int a, b, c;

signed main(void) {
	scanf("%d", &a);
	b = 0;
	if (a > b) {
		b = b + 1;
		c = a * b;
	}
	if (a > b + 1) {
		b = b + 1;
	}
	if (c * b > a + (b + c)) {
		printf("%d\n", (a));
	}
	return 0;
}

