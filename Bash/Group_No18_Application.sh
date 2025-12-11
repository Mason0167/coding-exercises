clear
n=3
echo Welcome to COMP1236 Group 18 Assignment
while [[ $n -gt 0 ]]
do 
 read -p "Please enter the password: " password
  if [[ "$password" != App1 ]]
   then
    ((n--))
    echo "The password is not match. "
   else	
    for ((;;)) do
	echo
	read -p " 
		<MENU>
	
Please type the letter, from A to C:

Task 1(A): Find all the triangular numbers

Task 2(B): The product of two natural numbers in succession

Task 3(C): Find the terms of a sequence given by the rule

Your choice is: " number		
    case $number in
     [Aa])
	echo "Welcome to Task 1!"

	#Input the range 

	echo "Enter the range (start and end):"
	read -r start end

	num=1
	x=0
	countTriangular=0
	CountEven=0
	CountOdd=0
	ProductsEven=1
	ProductsOdd=1

	echo;
	echo "Triangular Numbers within the range [$start, $end] :"
	echo;
	for ((num = start; num <= end; num++));
	do
		#check the triangular numbers with formula
		while [ $((x * (x + 1) / 2)) -le "$num" ]; 
		do
			if [ $((x * (x + 1) / 2)) -eq "$num" ]; 
			then
			    #find out this triangular number is even or odd number and count 		
	            	if [[ num%2 -eq 0 ]]
        	    	then
                	(( CountEven=CountEven+1 ))
                	echo $num " ; Even no.;" $CountEven "of Even number."
                	(( ProductsEven=ProductsEven*num ))
            	    else
                	((CountOdd=CountOdd+1))
                	echo $num " ;  Odd no.;" $CountOdd "of Odd number."
                	(( ProductsOdd=ProductsOdd*num ))
            	    fi
		countTriangular=$((countTriangular + 1))
		fi
	x=$((x + 1))
	done
        
	done
    
    echo;echo	
    echo "-----------------Summary------------------"
    echo "Total Triangular Numbers: " $countTriangular
    echo "     Count of total even: " $CountEven
    echo "      Count of total odd: " $CountOdd
    echo "  Products of total even: " $ProductsEven
    echo "   Products of total odd: " $ProductsOdd
	echo
	for ((;;))
	do
	echo;echo

	read -p "                <MENU>

If you want to continue with another task, type C or c 
or type E or e to exit
Your choice is : " number

	case $number in
	[Cc])
	continue 2
	;;
	[Ee])
	exit
	;;
	*)
	echo "Please type either (C/c)continue or (E/e)exit"
	;;
	esac
	done
	;;
     [Bb])
	echo "Welcome to Task 2!"

	read -p "Please enter an natural number: " natural_number
	read -p "How many number you want to print: " how_many
	read -p "Please enter a number to check whether it's one of a factor: " factor_number
	echo
	count=0


	if [[ $natural_number =~ ^[0-9]+$ && $how_many =~ ^[0-9]+$ && $factor_number =~ ^[0-9]+$ ]]
	then
	while [[ $count -lt $how_many ]]
	do 
		((count++))
		new=$(($natural_number + 1))
		product=$(($natural_number * $new))
		modulus=$(($factor_number % $product))
		if [[ $modulus =~ 0 && $product -le $factor_number ]]
			then	
				echo $count ":" $product "," $product "is a factor of $factor_number"
			else
				echo $count ":" $product "," $product "is not a factor of $factor_number"
		fi
		natural_number=$(($natural_number + 1))
	done
	else
	echo "The numbers need to be an natural number (a positive integer)"	
	echo
	fi
	for ((;;))
	do
	echo;echo

	read -p "                <MENU>

If you want to continue with another task, type C or c 
or type E or e to exit
Your choice is : " number

	case $number in
	[Cc])
	continue 2
	;;
	[Ee])
	exit
	;;
	*)
	echo "Please type either (C/c)continue or (E/e)exit"
	;;
	esac
	done
	;;
     [Cc])
	echo "Welcome to Task 3!"

	# input section
	while true; do
	echo a=?
	read a
	if [ $a -lt 0 ];
		then
			echo The value must be non-negative integer. 
		else
			break
	fi
	done

	while true; do
	echo b=?
	read b
	if [ $b -lt 0 ];
		then
			echo The value must be non-negative integer. 
		else
			break
	fi
	done

	while true; do
	echo c=?
	read c
		if [ $c -lt 0 ];
			then
				echo The value must be non-negative integer. 
			else
				break
		fi
	done

	while true;do
	echo Starting from?
	read n1
	if [ $n1 -le 0 ];
		then
			echo The value must be positive integer. 
		else
			break
	fi
	done

	while true;do
	echo Until?
	read n2
	if [ $n2 -le 0 ];
		then
			echo The value must be positive integer. 
		else
			break
	fi
	done

	# --------------------
	echo Calculating Term\=an\^3\+bn\+c using a\=$a b\=$b c\=$c when n\=$n1\-$n2.
	let n=$n1
	while [ $n -le $n2 ];
	do
	let term=$(( $a * $n ** 3 + $b * $n + $c ))
	echo When n\=$n
	echo Term\=$term
	if [ $n -eq $n1 ]; 
		then
		let init=$(( $term ))
	fi
	
	if [ $n -eq $n2 ]; 
		then
			let final=$(( $term ))
	fi
	
	n=$((n+1));
	done

	#end of ---------------------------------------------

	echo The product of the first number $n1 and the last number $n2 is...
	amo=$((init * final))
	echo $amo
	rem=$((amo % 4))
	if [ $rem -eq 0 ]; 
	then
		echo The product is a multiple of number 4
	else
		echo The product is not a multiple of number 4
	fi
	for ((;;))
	do
	echo;echo

	read -p "                <MENU>

If you want to continue with another task, type C or c 
or type E or e to exit
Your choice is : " number

	case $number in
	[Cc])
	continue 2
	;;
	[Ee])
	exit
	;;
	*)
	echo "Please type either (C/c)continue or (E/e)exit"
	;;
	esac
	done
	;;
     *)
	echo "No matching task"
	continue
	;;
	esac
	done
	fi

done
echo "You entered wrong password for 3 times. For the security reason, the program will be terminated. "
