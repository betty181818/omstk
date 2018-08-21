#!/bin/sh

RETURN=`cat test.log | grep "FAILED" | wc -l`
if [ ${RETURN} -eq "0" ]; then
	echo "PASS!"
	exit 0
else
	echo "FAIL!"
	exit 1
fi         
    
