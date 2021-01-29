my $isBegin = 1;
my $linesRemoved = 0; # the next line may not be empty

while (<>) {
	s/<.*?>//g;
	if (/^\s*$/) {
		$linesRemoved = 1;
  	} else {
	    s/(^ +)|( +$)//g;
	    s/\s\s+/ /g;
	    
	    if (!$isBegin && $linesRemoved) {
      		print "\n";
    	}
	    print;
	    
	    $isBegin = 0;
	    $linesRemoved = 0;
  	}
}