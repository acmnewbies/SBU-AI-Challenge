
import random
import time
import sys

random.seed(time.time)

respone = ""

while (True):
	
	response = input()
	if response == "END":
		sys.exit(0)
	elif response == "ENTER_A_NUMBER":
		print(random.randint(1, 6))
	else:
		sys.exit(1)

