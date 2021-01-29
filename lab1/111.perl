while (<>) {
	print if /^(0|(1(01*0)*1))*$/;
}
#https://ru.qwe.wiki/wiki/Regular_expression
