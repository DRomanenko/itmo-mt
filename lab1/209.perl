while (<>) {
	s/\([^\)]*\)/\(\)/g;
	print;
} 